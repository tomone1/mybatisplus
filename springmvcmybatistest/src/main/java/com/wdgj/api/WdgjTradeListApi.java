package com.wdgj.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.diamond.model.pojo.JsonTradeRootBean;
import com.diamond.services.WdgjPageLogService;
import com.diamond.services.WdgjTradeInfoServices;
import com.wdgj.api.trade.WdgjReturnTradeService;
import com.wdgj.api.trade.impl.WdgjTradeConnectFail;
import com.wdgj.api.trade.impl.WdgjTradeFail;
import com.wdgj.api.trade.impl.WdgjTradeSuccess;
import com.wdgj.trade.WdgjTradeList;
import com.wdgj.util.QuaryTradeParams;
import com.wdgj.util.WdgjInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author tom
 * @Date 2018-04-17 15:16
 */
@Service
@Slf4j(topic = "tradeLog")
public class WdgjTradeListApi {
  @Autowired
  private WdgjTradeList wdgjTradeList;
  @Autowired
  private WdgjTradeInfoServices wdgjTradeInfoServices;
  @Autowired
  private WdgjTradeFail wdgjTradeFail;
  @Autowired
  private WdgjTradeConnectFail wdgjTradeConnectFail;
  @Autowired
  private WdgjTradeSuccess wdgjTradeSuccess;
  private WdgjReturnTradeService wdgjReturnTradeService;
  @Autowired
  private WdgjPageLogService wdgjPageLogService;
  public  WdgjReturnTradeService getWdgjReturnTradeService(String json){
    Map map = JSON.parseObject(json, Map.class);
    if("-1".equals(map.get("error_code")) || StringUtils.isEmpty(json)){
     return wdgjTradeConnectFail;
    }else if ("0".equals(map.get("returncode"))){
      return wdgjTradeSuccess;
    }else{
      return wdgjTradeFail;
    }
  }
  public void saveWdjTradeInfo()throws  Exception {
    wdgjTradeInfoServices.trunctateWdgjTradeInfo();
    boolean isContimue = true;
    long startTime = System.currentTimeMillis();
    String method = "wdgj.trade.list.get";
    int ContinueNum = 0;// 重试次数  默认喂一次
    List<Map<String, Object>> list = wdgjPageLogService.find(method);
    int invocationNum = 0;// 调用次数
    int invocationSingleNum = 0;// 调用次数
    int sumNum = 0;//总的数量
    int sumSingNum = 0;//总的数量
    for (Map<String, Object> pageMap : list) {
      QuaryTradeParams params = new QuaryTradeParams(pageMap);
      int pageNo = params.getPageNo();
      isContimue = true;
      ContinueNum = 0;// 重试次数
      while (isContimue && pageNo<10) {
        String json = "";
        params.setPageNo(pageNo);
        try {
          json = wdgjTradeList.httpPostString(params.getParams());
          invocationNum++;
          invocationSingleNum++;
        } catch(Exception e) {
          log.info("链接重试{}", e);
        }
        Map map = JSON.parseObject(json, Map.class);
        log.info(json);
        wdgjReturnTradeService=getWdgjReturnTradeService(json);
        wdgjReturnTradeService.setContimue(isContimue);
        wdgjReturnTradeService.setContinueNum(ContinueNum);
        wdgjReturnTradeService.setJson(json);
        wdgjReturnTradeService.setPageMap(pageMap);
        wdgjReturnTradeService.setSumNum(sumNum);
        wdgjReturnTradeService.setSumSingNum(sumSingNum);
        wdgjReturnTradeService.setPageNo(pageNo);
        wdgjReturnTradeService.save();

        //赋值
        isContimue=wdgjReturnTradeService.getContimue();
        ContinueNum=wdgjReturnTradeService.getContinueNum();
        sumNum=wdgjReturnTradeService.getSumNum();
        sumSingNum=wdgjReturnTradeService.getSumSingNum();
        pageMap=wdgjReturnTradeService.getPageMap();
        pageNo=wdgjReturnTradeService.getPageNo();
      }
      pageMap.put(WdgjInfoUtil.PAGENO,pageNo);
      if(invocationSingleNum>0){
      wdgjPageLogService.save(pageMap);// 更改页码 开始日期 结束日期
      }
      log.info("工程名[{}]归档类型[{}]订单调用的次数是 invocationSingleNum:{},存储的数量 sumSingNum :{}",pageMap.get(WdgjInfoUtil.PROJECT_NAME) ,pageMap.get(WdgjInfoUtil.SEARCHTYPE),invocationSingleNum, sumSingNum);
      sumSingNum=0;
      invocationSingleNum=0;
    }
    log.info("总的订单调用的次数是 invocationNum:{},存储的数量 sumNum :{}", invocationNum, sumNum);
    // 订单的迁移
    wdgjTradeInfoServices.distinctTrade();
    wdgjTradeInfoServices.moveTrade();
    wdgjTradeInfoServices.distinctCustomer();
    wdgjTradeInfoServices.moveCustomer();
    wdgjTradeInfoServices.updateCustomerInfo();
  }

}


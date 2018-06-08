package com.wdgj.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.diamond.model.pojo.JsonTradeRootBean;
import com.diamond.services.WdgjPageLogService;
import com.diamond.services.WdgjTradeInfoServices;
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
  private WdgjPageLogService wdgjPageLogService;
  public void saveWdjTradeInfo()throws  Exception {
    wdgjTradeInfoServices.trunctateWdgjTradeInfo();
    boolean isContimue = true;
    long startTime = System.currentTimeMillis();
    String method = "wdgj.trade.list.get";
    int ContinueNum = 0;// 重试次数  默认喂一次
    //boolean reCover=false;
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
        if ("-1".equals(map.get("error_code")) || StringUtils.isEmpty(json)) {
          log.info("" + map.get("error_info"));
          log.info("返回的json{}", json);

          ContinueNum++;
          /*
          *  一下代码是 针对链接不上数据库 次试的次数 大与两次
          * */
          if (ContinueNum > 2) {
            isContimue = false;

          }
        } else if ("0".equals(map.get("returncode"))) {
          JsonTradeRootBean jsonTradeRootBean = JSON.parseObject(json, JsonTradeRootBean.class);
          if(jsonTradeRootBean.getDatalist().size()>0){
            pageNo++;
          }
          //  log.info(""+jsonTradeRootBean.getReturncode());
          if (jsonTradeRootBean.getDatalist(pageMap.get(WdgjInfoUtil.SHOPIDS).toString()).size() > 0) {
            try {
              wdgjTradeInfoServices.saveTradeInfo(jsonTradeRootBean.getDatalist(pageMap.get(WdgjInfoUtil.SHOPIDS).toString()));
              sumNum += Integer.parseInt(jsonTradeRootBean.getReturninfo());
              sumSingNum += Integer.parseInt(jsonTradeRootBean.getReturninfo());
              log.info("每页的数量 pageNum{},单总数量sumSingNum{},店铺名[{}],归档类型[{}]", jsonTradeRootBean.getReturninfo(), sumSingNum,pageMap.get(WdgjInfoUtil.PROJECT_NAME),pageMap.get(WdgjInfoUtil.SEARCHTYPE));
            } catch(Exception e) {
              pageMap.put(WdgjInfoUtil.ERROR_INFO,e.getMessage().substring(1,254));
              wdgjPageLogService.saveTradeErrorLog(pageMap);
              log.error("第{}页数据没有存进数据库 数据参数{},{}", pageNo, JSON.toJSON(pageMap),e);
              isContimue = false; // 存不进去的话继续存
            }

          } else if("0".equals(jsonTradeRootBean.getReturninfo())) {
            log.info("错误代码 {},{},{}", jsonTradeRootBean.getReturncode(), json);
            pageMap.put(WdgjInfoUtil.BEGINTIME,new Date());
            pageMap.put(WdgjInfoUtil.ENDTIME,null);
            isContimue = false;
          }else {
            /*
             没有数据继续
             没有数据继续
            * */
            isContimue = true;
          }
        }else{
          isContimue=false;
        }
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

  }
}


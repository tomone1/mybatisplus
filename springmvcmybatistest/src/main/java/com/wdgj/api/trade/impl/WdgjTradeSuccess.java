package com.wdgj.api.trade.impl;

import com.alibaba.fastjson.JSON;
import com.diamond.model.dto.WdgjTradeInfo;
import com.diamond.model.pojo.JsonTradeRootBean;
import com.diamond.services.WdgjPageLogService;
import com.diamond.services.WdgjTradeInfoServices;
import com.wdgj.api.trade.WdgjReturnTradeService;
import com.wdgj.util.WdgjInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-06-08 15:19
 */
@Service
@Slf4j(topic = "tradeLog")
public class WdgjTradeSuccess extends WdgjReturnTradeService {
  @Autowired
  private WdgjTradeInfoServices wdgjTradeInfoServices;
  @Autowired
  private WdgjPageLogService wdgjPageLogService;
  @Override
  public void save() {
    JsonTradeRootBean jsonTradeRootBean = JSON.parseObject(json, JsonTradeRootBean.class);
    if(jsonTradeRootBean.getDatalist().size()>0){
      pageNo++;
    }
    /*
      过滤店铺的数据
    * */
    List<WdgjTradeInfo> list=jsonTradeRootBean.getDatalist(pageMap.get(WdgjInfoUtil.SHOPIDS).toString());
    if (list.size() > 0) {
      try {

        wdgjTradeInfoServices.saveTradeInfo(list);
        sumNum += list.size();
        sumSingNum +=list.size();
        log.info("每页的数量 pageNum{},单总数量sumSingNum{},店铺名[{}],归档类型[{}]", jsonTradeRootBean.getReturninfo(), sumSingNum,pageMap.get(WdgjInfoUtil.PROJECT_NAME),pageMap.get(WdgjInfoUtil.SEARCHTYPE));
      } catch(Exception e) {
        pageMap.put(WdgjInfoUtil.ERROR_INFO,e.getMessage().substring(1,254));
        wdgjPageLogService.saveTradeErrorLog(pageMap);
        log.error("第{}页数据没有存进数据库 数据参数{},{}", pageNo, JSON.toJSON(pageMap),e);
        Contimue = false; // 存不进去的话继续存
      }

    } else if("0".equals(jsonTradeRootBean.getReturninfo())) {
      log.info("错误代码 {},{},{}", jsonTradeRootBean.getReturncode(), json);
      pageMap.put(WdgjInfoUtil.BEGINTIME,new Date());
      pageMap.put(WdgjInfoUtil.ENDTIME,null);
      Contimue = false;
    }else {
      Contimue = true;
    }
  }
}

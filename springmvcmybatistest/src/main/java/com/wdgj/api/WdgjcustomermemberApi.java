package com.wdgj.api;

import com.alibaba.fastjson.JSON;
import com.diamond.model.pojo.JsonCustomerRootBean;
import com.diamond.services.WdgjCustomerInfoServices;
import com.diamond.services.WdgjPageLogService;
import com.wdgj.customer.Wdgjcustomermemberlist;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

/**
 * @Author tom
 * @Date 2018-04-16 15:54
 */
@Slf4j(topic = "customerLog")
@Service
public class WdgjcustomermemberApi {
  /*
  * 获取  返回的json服务
  * */
  @Autowired
  private Wdgjcustomermemberlist wdgjcustomermemberlist;
  /*
  * 保存信息 服务
  * */
  @Autowired
  private WdgjCustomerInfoServices wdgjCustomerInfoServices;
  @Autowired
  private WdgjPageLogService wdgjPageLogService;
  public void saveWdgjCustomerInfo() throws Exception{
//    boolean isContimue=true;
//    long startTime=System.currentTimeMillis();
//    int invocationNum=0;// 调用次数
//    int sumNum=0;//客户总的数量
//    int pageNum=1;//页码
//    int continuenum=0;//重试次数
//    String moditeTime="";
//    String method="wdgj.customer.member.list";
//    Map pageMap=wdgjPageLogService.find(method);
//    Optional<Map> optional=Optional.ofNullable(pageMap);
//    if(optional.isPresent()){
//      if(optional.get().get("pageNum")!=null){
//        pageNum=Integer.parseInt(optional.get().get("pageNum").toString());
//      }
//      if(optional.get().get("startTime")!=null){
//        moditeTime=optional.get().get("startTime").toString();
//      }else{
//        moditeTime= LocalDate.now().toString();
//      }
//    }
//    while (isContimue){
//      String json="";
//      try{
//         json=wdgjcustomermemberlist.httpPostString(Integer.toString(pageNum),moditeTime);
//
//      }catch(Exception e){
//          log.info("http 连接重式，{}",e);
//
//      }
//          //
//      Map map= JSON.parseObject(json,Map.class);
//      if("-1".equals(map.get("error_code"))|| StringUtils.isEmpty(json)){
//        log.info(""+map.get("error_info"));
//        log.info("返回的json{}",json);
//        continuenum++;
//        if(continuenum>2){
//          isContimue=false;
//        }
//
//      }else if("0".equals(map.get("error_code"))){
//        JsonCustomerRootBean jsonCustomerRootBean= JSON.parseObject(json,    JsonCustomerRootBean.class);
//        log.info(jsonCustomerRootBean.getError_code());
//        if(jsonCustomerRootBean.getCustomer_info_list().size()>0){
//          try{
//            wdgjCustomerInfoServices.saveCustomerInfo(jsonCustomerRootBean.getCustomer_info_list());
//
//          }catch(Exception e){
//            e.printStackTrace();
//            isContimue=false;
//            log.error("客户数据存储错误{},{},",json, e );
//          }
//
//          invocationNum++;
//          pageNum++;
//          sumNum+=Integer.parseInt(jsonCustomerRootBean.getError_info());
//        }else{
//          log.info("返回的json{}",json);
//          isContimue=false;
//          moditeTime=null;
//          pageNum=1;
//        }
//
//      }
//    }
//    pageMap.put("pageNum",pageNum);
//    pageMap.put("startTime",moditeTime);
//    wdgjPageLogService.save(pageMap);
//    long endTime=System.currentTimeMillis();
//    log.info("调用的次数是 pageNum:{},存储的数量 sumNum :{}",pageNum-1,sumNum);
//    log.info("添加是时间为"+(endTime-startTime));
  }

}

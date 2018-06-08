package com.wdgj.thread;

import com.alibaba.fastjson.JSON;
import com.diamond.model.pojo.JsonCustomerRootBean;
import com.diamond.services.WdgjCustomerInfoServices;
import com.wdgj.customer.Wdgjcustomermemberlist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * @Author tom
 * @Date 2018-04-13 14:03
 */
@Slf4j
@Service
public class WdgjcustomermemberThread {
  @Autowired
  private Wdgjcustomermemberlist wdgjcustomermemberlist;
  @Autowired
  private WdgjCustomerInfoServices wdgjCustomerInfoServices;
  private static ExecutorService executor;
  private  volatile int pageNum=0;// 页码
  private volatile boolean isContimue=true;// 是否继续循环
  private volatile int invoctationNum=0;//接口调用次数哦
  private volatile int sumCustomerNum=0;//总共存储的会员数量
  /*
  * 多线程存储
  * */
  public void saveMultiCustomerInfo(){
    executor= Executors.newFixedThreadPool(5);// 新建固定的线程池
    long startTime=System.currentTimeMillis();
    sumCustomerNum=0;
    pageNum=0;
    System.out.println(pageNum+"pagenum");
    while (isContimue){

      // log.info("pageNum{}",pageNum);
      executor.execute(new Runnable() {
        @Override
        public void run() {
          String json="";
          JsonCustomerRootBean jsonCustomerRootBean=new JsonCustomerRootBean();
          try{
         /*  if(isContimue) {*/
         int num=0;
            synchronized (json){
              pageNum++;
              num=pageNum;
            }
             invoctationNum++;
             log.info("pageNum++++77+{}",pageNum);
             Thread.sleep(1000);
             json = wdgjcustomermemberlist.httpPostString(Integer.toString(num),"2001");
             log.info("网店管家返回的数据 " + json);
             jsonCustomerRootBean = JSON.parseObject(json, JsonCustomerRootBean.class);
             System.out.println("isContimue:"+isContimue);
           /*}else{
             return;
           }*/

          }catch(Exception e){
            log.error("网店管家接口返回错误");
            e.printStackTrace();
          }


          if(0==jsonCustomerRootBean.getCustomer_info_list().size()){
            isContimue=false;
          }else if("-1".equals(jsonCustomerRootBean.getError_code())){
            isContimue=false;
            log.info("调用次数已满"+jsonCustomerRootBean.getError_info());
          } else if("".equals(jsonCustomerRootBean.getError_code())){
            log.info("888888888888888*********************");
          } else{
            Map map=JSON.parseObject(json,Map.class);
            sumCustomerNum+=Integer.parseInt(jsonCustomerRootBean.getError_info());
            log.info(jsonCustomerRootBean.getError_code());
            wdgjCustomerInfoServices.saveCustomerInfo(jsonCustomerRootBean.getCustomer_info_list());
          }
        }
      });

    }
if(!isContimue){
      try{
       // Thread.sleep(1000);
        long endTime=System.currentTimeMillis();
        pageNum=0;
        log.info("添加是时间为"+(endTime-startTime));
        log.info("接口调用次数invoctationNum {},存储的会员数量是sumCustomerNum{}",invoctationNum,sumCustomerNum);
      }catch(Exception e){
        e.printStackTrace();
      }



}

  }
}

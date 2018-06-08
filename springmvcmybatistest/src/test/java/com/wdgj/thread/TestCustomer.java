package com.wdgj.thread;

import com.alibaba.fastjson.JSON;
import com.diamond.mapper.WdgjCustomerInfoMapper;
import com.diamond.model.dto.CustomerInfoDto;
import com.diamond.model.pojo.JsonCustomerRootBean;
import com.diamond.services.WdgjCustomerInfoServices;
import com.wdgj.customer.Wdgjcustomermemberlist;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author tom
 * @Date 2018-04-10 15:33
 */
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TestCustomer {
@Autowired
  private Wdgjcustomermemberlist wdgjcustomermemberlist;
@Autowired
private WdgjCustomerInfoServices wdgjCustomerInfoServices;
  private static ExecutorService executor;
  private volatile int num=1;
  private volatile int a=1;
  private volatile int checknum=1;
  private volatile int callnum=1;
 @Test
public void test(){
  executor= Executors.newFixedThreadPool(1);
  long startTime=System.currentTimeMillis();


  while (a>0){
    num++;
    executor.execute(new Runnable() {
      @Override
      public void run() {
        String json="";
        //if(a==0){}
        try{
           json=wdgjcustomermemberlist.httpPostString(Integer.toString(num),"2017-01-01");
          log.info("1111111111111111111111111"+json);
        }catch(Exception e){
e.printStackTrace();
        }

        JsonCustomerRootBean jsonCustomerRootBean= JSON.parseObject(json,    JsonCustomerRootBean.class);
        if(jsonCustomerRootBean.getError_code().equals("0")&&jsonCustomerRootBean.getCustomer_info_list().size()==0){
          log.info("888888888888888888888888888888");
          a=0;
        }else{
          Map map=JSON.parseObject(json,Map.class);
          log.info(jsonCustomerRootBean.getError_code());
          wdgjCustomerInfoServices.saveCustomerInfo(jsonCustomerRootBean.getCustomer_info_list());

        }
      }
    });

  }

  long endTime=System.currentTimeMillis();
  log.info("添加是时间为"+(endTime-startTime));

}
@Test
public void method()throws Exception{

  long startTime=System.currentTimeMillis();
  int a=1;
  int numq=1;
 while (a>0){
    String json=wdgjcustomermemberlist.httpPostString(Integer.toString(numq),"2017-01-01");
   log.info("1111111111111111111111111"+json);
    Map map=JSON.parseObject(json,Map.class);
    if("-1".equals(map.get("error_code"))){
      log.info(""+map.get("error_info"));
      break;
    }
    JsonCustomerRootBean jsonCustomerRootBean= JSON.parseObject(json,    JsonCustomerRootBean.class);

    if(jsonCustomerRootBean.getCustomer_info_list().size()==0){
     break;
    }
    //Map map=JSON.parseObject(json,Map.class);
    log.info(jsonCustomerRootBean.getError_code());
    wdgjCustomerInfoServices.saveCustomerInfo(jsonCustomerRootBean.getCustomer_info_list());
    numq++;
 }

  long endTime=System.currentTimeMillis();
  log.info("添加是时间为"+(endTime-startTime));
  }
  @Test
  public void singlon() throws Exception{
    wdgjcustomermemberlist.httpPostString("10000","");
  }


}

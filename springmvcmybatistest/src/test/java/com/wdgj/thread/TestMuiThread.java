package com.wdgj.thread;

import com.diamond.model.pojo.JsonCustomerRootBean;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author tom
 * @Date 2018-04-13 16:45
 */
@Slf4j
public class TestMuiThread {

  private static ExecutorService executor;
  private  volatile int pageNum=0;// 页码
  private volatile boolean isContimue=true;// 是否继续循环
  private volatile int invoctationNum=0;//接口调用次数哦
  private volatile int sumCustomerNum=0;//总共存储的会员数量
  private  volatile  int tes=0;
  /*
  * 多线程存储
  * */
  public void saveMultiCustomerInfo(){
    executor= Executors.newFixedThreadPool(2);// 新建固定的线程池
    long startTime=System.currentTimeMillis();
    sumCustomerNum=0;
     pageNum=0;
    //System.out.println(pageNum+"pagenum");
    while (isContimue){
      tes++;
       log.info("tes[1]:[{}]",tes);
      executor.execute(new Runnable() {
        @Override
        public void run() {
          String json="";
          JsonCustomerRootBean jsonCustomerRootBean=new JsonCustomerRootBean();
          try{
            invoctationNum++;
            pageNum++;
            if(isContimue) {
              log.info("pageNum[2]:[{}]",pageNum);
          //    json = wdgjcustomermemberlist.httpPostString(Integer.toString(pageNum));
             // log.info("网店管家返回的数据 " + json);
           //   jsonCustomerRootBean = JSON.parseObject(json, JsonCustomerRootBean.class);
            }else{
              return;
            }

          }catch(Exception e){
            log.error("网店管家接口返回错误");
            e.printStackTrace();
          }
        if (pageNum==8000){
            isContimue=false;
        }

      /*    if(0==jsonCustomerRootBean.getCustomer_info_list().size()){
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

          }*/
        }
      });

    }
    System.out.println(pageNum+"pageNum:");
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
  public static void main(String[] args) {
  new TestMuiThread().saveMultiCustomerInfo();
  }
}

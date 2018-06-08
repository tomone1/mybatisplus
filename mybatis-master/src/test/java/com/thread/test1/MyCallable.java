package com.thread.test1;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @Author tom
 * @Date 2018/3/27 15:19
 */

public class MyCallable implements Callable<Object> {
  private String taskNum;

  public MyCallable(String taskNum) {
    this.taskNum = taskNum;
  }

  /**
   * Computes a result, or throws an exception if unable to do so.
   *
   * @return computed result
   * @throws Exception if unable to compute a result
   */
  @Override
  public Object call() throws Exception {
    System.out.println(">>>"+taskNum+"任务启动");
    Date date=new Date();
    Thread.sleep(1000);
    Date date1=new Date();
    long time=date1.getTime()-date.getTime();
    System.out.println(">>>"+taskNum+"任务终止");

    return taskNum+"任务返回结果,当前任务时间"+time+"毫秒";
  }
}

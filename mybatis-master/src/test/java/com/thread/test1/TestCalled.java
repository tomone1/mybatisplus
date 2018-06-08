package com.thread.test1;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author tom
 * @Date 2018/3/27 15:24
 */

public class TestCalled {
  public static void main(String[] args) throws ExecutionException,InterruptedException{
    System.out.println("程序开始运行");
    Date date=new Date();
    int taskSize=5;
    // 创建个线程池
    ExecutorService poll= Executors.newFixedThreadPool(taskSize);
    // 创建有多个返回值的任务
    List<Future> list=new ArrayList<>();
    for (int i=0;i<taskSize;i++){
      Callable c=new MyCallable(i+"");
      //执行任务并获取Future 对象
      Future future=poll.submit(c);
      list.add(future);
    }
    // 关闭线程池
    poll.shutdown();
    //获取所有并发任务的运行结果
    for (Future f:list){
      System.out.println(">>>"+f.get().toString());
    }
    Date date1=new Date();
    long time=date1.getTime()-date.getTime();
    System.out.println("程序运行时间是"+time+"毫秒");
  }



}

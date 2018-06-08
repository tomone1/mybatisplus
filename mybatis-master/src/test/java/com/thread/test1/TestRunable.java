package com.thread.test1;

/**
 * @Author tom
 * @Date 2018/3/27 15:07
 */

public class TestRunable {
  public static void main(String[] args) {
    System.out.println("主线程id:"+Thread.currentThread().getId());
    MyRunable runable=new MyRunable();
    Thread thread=new Thread(runable);

    thread.start();

  }

}

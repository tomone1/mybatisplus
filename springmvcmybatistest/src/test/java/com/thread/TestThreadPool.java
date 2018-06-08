package com.thread;


/**
 * @Author tom
 * @Date 2018-04-12 14:07
 */

public class TestThreadPool {
  public static void main(String[] args) {
    ThreadPool t=ThreadPool.getThreadPool(3);
    t.execute(new Runnable[]{new Task(),new Task(),new Task()});
    t.execute(new Runnable[]{new Task(),new Task(),new Task()});
    System.out.println(t);
    t.destory();//所有的线程执行完才desstory
    System.out.println(t);

  }
  // 任务类
  static class Task implements Runnable{
    private static   volatile int i=1;


    @Override
    public void run() {
      System.out.println("任务"+(i++)+"完成");
    }
  }
}

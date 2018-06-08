package com.thread.test1;

/**
 * @Author tom
 * @Date 2018/3/27 15:11
 */

public class MyRunable implements Runnable {
  /**
   * When an object implementing interface <code>Runnable</code> is used
   * to create a thread, starting the thread causes the object's
   * <code>run</code> method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method <code>run</code> is that it may
   * take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    System.out.println("子线程id:"+Thread.currentThread().getId());
  }

  public MyRunable() {
  }
}

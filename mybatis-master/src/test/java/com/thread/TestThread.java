package com.thread;

/**
 * @Author tom
 * @Date 2018/3/26 17:09
 */

public class TestThread implements Runnable {

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
    System.out.println("hello ,Java Thread");
  }

  public static void main(String[] args) {
    TestThread testThread=new TestThread();
    Thread thread=new Thread(testThread);
    thread.start();
    try{
      Thread.sleep(5*1000*2);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }

}

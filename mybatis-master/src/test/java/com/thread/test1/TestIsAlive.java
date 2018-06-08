package com.thread.test1;

/**
 * @Author tom
 * @Date 2018/3/27 17:01
 */

public class TestIsAlive extends Thread {
  /**
   * If this thread was constructed using a separate
   * <code>Runnable</code> run object, then that
   * <code>Runnable</code> object's <code>run</code> method is called;
   * otherwise, this method does nothing and returns.
   * <p>
   * Subclasses of <code>Thread</code> should override this method.
   *
   * @see #start()
   * @see #stop()
   * @see #Thread(ThreadGroup, Runnable, String)
   */
  @Override
  public void run() {
    System.out.println("run="+this.isAlive());
  }

  public static void main(String[] args)throws InterruptedException {
    TestIsAlive testIsAlive =new TestIsAlive();
    System.out.println("begin=="+testIsAlive.isAlive());
    testIsAlive.start();
    Thread.sleep(1000);
    System.out.println("end=="+testIsAlive.isAlive());
  }
}

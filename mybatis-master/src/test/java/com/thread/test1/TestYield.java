package com.thread.test1;

/**
 * @Author tom
 * @Date 2018/3/27 16:47
 */

public class TestYield extends Thread{
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
    long begintime=System.currentTimeMillis();

    int count=0;
    for (int i=0;i<50000000;i++){
      count=count+(i+1);
     // Thread.yield();
    }
    System.out.println("count="+count);
    long endtime=System.currentTimeMillis();
    long time=endtime-begintime;
    System.out.println("用时"+time+"毫秒");
  }

  public static void main(String[] args) {
    TestYield testYield=new TestYield();
    testYield.start();
  }
}

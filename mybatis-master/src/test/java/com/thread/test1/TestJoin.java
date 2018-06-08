package com.thread.test1;

/**
 * @Author tom
 * @Date 2018/3/27 17:29
 */

public class TestJoin extends Thread {




  /**
   * Allocates a new {@code Thread} object. This constructor has the same
   * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
   * {@code (null, null, gname)}, where {@code gname} is a newly generated
   * name. Automatically generated names are of the form
   * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
   */
  public TestJoin(String name) {
    super(name);
  }

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
    for (int i = 0; i <5 ; i++) {
      System.out.println(getName()+" "+i);
    //  System.out.println(Thread.currentThread().getName());
    }
  }

  public static void main(String[] args)throws InterruptedException {
    new TestJoin("new thread").start();
    for (int i = 0; i <10 ; i++) {
     if(i==5){
       TestJoin testJoin=new TestJoin("joined thread");

       testJoin.start();
       testJoin.join();
     }
      System.out.println(Thread.currentThread().getName()+"  "+i);
    }

  }

}

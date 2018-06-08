package com.thread.test1;

/**
 * @Author tom
 * @Date 2018/3/27 14:50
 */

public class MyThread extends Thread{
  private static int num=0;
  private String name;

  /**
   * Allocates a new {@code Thread} object. This constructor has the same
   * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
   * {@code (null, null, gname)}, where {@code gname} is a newly generated
   * name. Automatically generated names are of the form
   * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
   */
  public MyThread(String name) {
    this.name=name;
    num++;
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
    System.out.println("主动创建的第"+num+"个线程");
    System.out.println("name:"+name+"子线程id:"+Thread.currentThread().getId());
  }

  public static void main(String[] args) {
    System.out.println("主线程Id:"+Thread.currentThread().getId());
    MyThread thread1=new MyThread("thread1");
    thread1.start();
    MyThread thread2=new MyThread("thread2");
    thread2.run();
  }
}

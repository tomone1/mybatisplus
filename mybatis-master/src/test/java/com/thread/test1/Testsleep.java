package com.thread.test1;

/**
 * @Author tom
 * @Date 2018/3/27 16:26
 */

public class Testsleep {

  private int i=10;
  private Object object=new Object();

  public static void main(String[] args) {
    Testsleep testsleep=new Testsleep();
    MyThread myThread1=testsleep.new MyThread();
    MyThread myThread2=testsleep.new MyThread();
    myThread1.start();
    myThread2.start();
  }
  class MyThread extends Thread{
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
      synchronized (object){
        i++;
        System.out.println("i:"+i);
        try{
          System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠");
          Thread.currentThread().sleep(1000);

        }catch(InterruptedException e){
          e.getMessage();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
        i++;
        System.out.println("i:"+i);
      }
    }
  }
}

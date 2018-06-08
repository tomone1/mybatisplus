package com.thread;

import lombok.extern.slf4j.Slf4j;

import javax.print.attribute.standard.RequestingUserName;
import java.util.concurrent.*;

/**
 * @Author tom
 * @Date 2018/3/26 17:40
 */
//@SuppressLint("NewApi")
  @Slf4j
public class MyThreadPool {
  private final static int POOL_SIZE = 4;// 线程池的大小最好设置成为CUP核数的2N 
  private final static int MAX_POOL_SIZE = 4;// 设置线程池的最大线程数  
  private final static int KEEP_ALIVE_TIME = 4;// 设置线程的存活时间 
  private  Executor mExecutor;
  private final static MyThreadPool myPool = new MyThreadPool();
  //@SuppressLint("NewApi")
  private MyThreadPool() {
    // 创建线程池工厂  
   ThreadFactory factory = new PriorityThreadFactory("thread-pool",0);// 创建工作队列  
BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
   mExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue, factory);

  }
  public static MyThreadPool getInter(){
    return myPool;
  }
  public void submit(Runnable command){
    mExecutor.execute(command);
  }
 static Runnable run = new Runnable() {
    @Override
    public void run() {
      log.info("这是一个线程任务", "这是一个线程任务");
    }

  };


  public static void main(String[] args) {
    MyThreadPool.getInter().submit(run);
  }
}

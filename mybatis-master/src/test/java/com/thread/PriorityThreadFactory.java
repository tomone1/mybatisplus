package com.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author tom
 * @Date 2018/3/26 17:45
 */

public class PriorityThreadFactory implements ThreadFactory {
  /**
   * Constructs a new {@code Thread}.  Implementations may also initialize
   * priority, name, daemon status, {@code ThreadGroup}, etc.
   *
   * @param r a runnable to be executed by new thread instance
   * @return constructed thread, or {@code null} if the request to
   * create a thread is rejected
   */
 /* @Override
  public Thread newThread(Runnable r) {
    return null;
  }*/
  private final String mName;
  private final int mPriority;
  private final AtomicInteger mNumber = new AtomicInteger();
  public PriorityThreadFactory(String name, int priority) {
    mName = name;// 线程池的名称
    mPriority = priority;//线程池的优先级  
  }
  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, mName +"-"+mNumber.getAndIncrement()){                         @Override
    public void run() {
      // 设置线程的优先级  
   //   android.os.Process.setThreadPriority(mPriority);
//                setPriority(mPriority);  
   super.run();
    }
        };

}

}

package com.thread;

import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author tom
 * @Date 2018-04-12 14:26
 */

public class TestThreadPoolExceport {
  private static ExecutorService executor;
  public static void main(String[] args) {
    executor= Executors.newFixedThreadPool(5);
    executor.execute(new Runnable() {
      @Override
      public void run() {

      }
    });
  }
}

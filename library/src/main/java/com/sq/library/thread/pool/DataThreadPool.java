package com.sq.library.thread.pool;

import com.sq.library.thread.util.UIThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataThreadPool {
  private static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(4);

  public static void submit(final Job job) {
    threadPoolExecutor.submit(() -> {
      job.run();

      UIThreadUtil.post(() -> job.onPostRun());
    });
  }
}

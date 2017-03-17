package com.sq.library.thread.util;

import android.os.Handler;
import android.os.Looper;

public class UIThreadUtil {
  private static Handler uiHandler = new Handler(Looper.getMainLooper());

  private UIThreadUtil() {
    // Do noting
  }

  public static void post(Runnable runnable) {
    uiHandler.post(runnable);
  }

  public static void postDelayed(Runnable runnable, long delayMillis) {
    uiHandler.postDelayed(runnable, delayMillis);
  }
}

package com.sq.library.log;

import android.util.Log;

public class Logger {
  private static int level = Log.VERBOSE;

  public static void init(int level) {
    Logger.level = level;
  }

  public static int v(String tag, String msg) {
    if (level > Log.VERBOSE) {
      return -1;
    }

    return Log.v(tag, msg);
  }

  public static int d(String tag, String msg) {
    if (level > Log.DEBUG) {
      return -1;
    }

    return Log.d(tag, msg);
  }

  public static int i(String tag, String msg) {
    if (level > Log.INFO) {
      return -1;
    }

    return Log.i(tag, msg);
  }

  public static int w(String tag, String msg) {
    if (level > Log.WARN) {
      return -1;
    }

    return Log.w(tag, msg);
  }

  public static int e(String tag, String msg) {
    if (level > Log.ERROR) {
      return -1;
    }

    return Log.e(tag, msg);
  }

  public static void logException(Throwable e) {
    Logger.e("Exception", e.toString());

    StackTraceElement[] elements = e.getStackTrace();
    for (StackTraceElement element : elements) {
      Logger.e("Exception", element.toString());
    }
  }
}

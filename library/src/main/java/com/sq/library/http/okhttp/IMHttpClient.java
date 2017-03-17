package com.sq.library.http.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class IMHttpClient {
  public static OkHttpClient getHttpClient() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static OkHttpClient INSTANCE = new OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build();
  }
}

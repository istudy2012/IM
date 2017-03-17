package com.sq.library.http;

import com.sq.library.http.okhttp.OkHttpRequestManager;

public class HttpClient {

  public static IRequestManager getInstance() {
    return OkHttpRequestManager.getInstance();
  }
}

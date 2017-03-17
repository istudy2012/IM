package com.sq.library.http;

public interface IRequestCallback {
  void onSuccess(String response);

  void onFailure(Throwable throwable);
}

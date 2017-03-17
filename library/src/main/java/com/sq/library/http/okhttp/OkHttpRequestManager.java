package com.sq.library.http.okhttp;

import com.sq.library.http.IRequestCallback;
import com.sq.library.http.IRequestManager;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpRequestManager implements IRequestManager {
  private OkHttpClient okHttpClient;

  private static final MediaType TYPE_JSON
      = MediaType.parse("application/json; charset=UTF-8");

  private OkHttpRequestManager() {
    okHttpClient = IMHttpClient.getHttpClient();
  }

  public static OkHttpRequestManager getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final OkHttpRequestManager INSTANCE = new OkHttpRequestManager();
  }

  @Override
  public void get(String url, IRequestCallback requestCallback) {
    Request request = new Request.Builder()
        .url(url)
        .build();

    startRequest(request, requestCallback);
  }

  @Override
  public void post(String url, String requestBodyJson, IRequestCallback requestCallback) {
    RequestBody body = RequestBody.create(TYPE_JSON, requestBodyJson);
    Request request = new Request.Builder()
        .url(url)
        .post(body)
        .build();

    startRequest(request, requestCallback);
  }

  @Override
  public void put(String url, String requestBodyJson, IRequestCallback requestCallback) {
    RequestBody body = RequestBody.create(TYPE_JSON, requestBodyJson);
    Request request = new Request.Builder()
        .url(url)
        .put(body)
        .build();

    startRequest(request, requestCallback);
  }

  @Override
  public void delete(String url, String requestBodyJson, IRequestCallback requestCallback) {
    RequestBody body = RequestBody.create(TYPE_JSON, requestBodyJson);
    Request request = new Request.Builder()
        .url(url)
        .delete(body)
        .build();

    startRequest(request, requestCallback);
  }

  private void startRequest(Request request, final IRequestCallback callback) {
    okHttpClient.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        callback.onFailure(e);
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
          final String jsonStr = response.body().string();
          callback.onSuccess(jsonStr);
        } else {
          callback.onFailure(new IOException("Unexpected code " + response));
        }
      }
    });
  }
}

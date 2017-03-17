package com.sq.library.thread.pool;

public abstract class Job {
  protected abstract void run();

  protected void onPostRun() {
    // Default nothing
  }
}

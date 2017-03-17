package com.sq.library.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {
  public static void display(String uri, ImageView imageView) {
    Glide.with(imageView.getContext())
        .load(uri)
        .into(imageView);
  }
}

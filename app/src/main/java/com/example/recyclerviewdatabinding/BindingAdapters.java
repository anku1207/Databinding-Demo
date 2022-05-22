package com.example.recyclerviewdatabinding;


import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;



/**
 * Created by Ganesh on 3/5/2018.
 */

public class BindingAdapters {

    //TODO Add a private constructor to hide the implicit public one.

    private static final String TAG = BaseActivity.class.getSimpleName();

    private BindingAdapters() {
        throw new IllegalStateException("BindingAdapters class");
    }

    @BindingAdapter("isVisible")
    public static void setVisibility(View view, Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("imsResourceId")
    public static void imageIcon(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }



    @BindingAdapter("app:srcCompat")
    public static void bindSrcCompat(AppCompatImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }




}


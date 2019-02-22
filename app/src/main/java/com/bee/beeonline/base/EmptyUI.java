package com.bee.beeonline.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.bee.beeonline.R;

public class EmptyUI {
    public View view;

    public EmptyUI(Context ctx) {
        view = LayoutInflater.from(ctx).inflate(R.layout.layout_empty, null);
    }
}

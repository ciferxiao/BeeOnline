package com.bee.beeonline.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by jmy on 2017/3/7.
 */

public class ColorUtil {
    public static int getColor(Context context, int colorRes) {
        return context.getResources().getColor(colorRes);
    }

    public static Drawable getDrawable(Context context, int drawableRes) {
        return context.getResources().getDrawable(drawableRes);
    }
}

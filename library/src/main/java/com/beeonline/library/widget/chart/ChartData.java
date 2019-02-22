package com.beeonline.library.widget.chart;

import android.support.annotation.ColorInt;

/**
 * Created by 123 on 2018/4/2.
 */

public abstract class ChartData {
    @ColorInt
    private int color;

    public abstract String getChartXValue();

    public abstract float getChartYValue();

    @ColorInt
    public int getPointColor() {
        return color;
    }

    public void setPointColor(@ColorInt int color) {
        this.color = color;
    }
}

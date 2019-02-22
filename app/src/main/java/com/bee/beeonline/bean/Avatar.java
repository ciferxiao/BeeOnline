package com.bee.beeonline.bean;

import android.text.TextUtils;

import java.io.Serializable;

public class Avatar implements Serializable {
    private String width;
    private String height;
    private String part_large;
    private String part_thumb;
    private String thumb;
    private String large;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPart_large() {
        return part_large;
    }

    public void setPart_large(String part_large) {
        this.part_large = part_large;
    }

    public String getPart_thumb() {
        return part_thumb;
    }

    public void setPart_thumb(String part_thumb) {
        this.part_thumb = part_thumb;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getLarge() {
        return TextUtils.isEmpty(large) ? "" : large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}

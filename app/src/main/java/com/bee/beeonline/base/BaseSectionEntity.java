package com.bee.beeonline.base;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.List;

/**
 * Created by 59395 on 2018/5/12.
 */

public abstract class BaseSectionEntity<T> extends SectionEntity<T> {
    public List<String> headers;

    public BaseSectionEntity(boolean isHeader, String header, List<String> headers) {
        super(isHeader, header);
        this.headers = headers;
    }

    public BaseSectionEntity(T t) {
        super(t);
    }
}

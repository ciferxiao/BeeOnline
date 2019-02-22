package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class ShowParentBean extends BaseData {

    private List<ShowBean> data;

    public List<ShowBean> getData() {
        return data;
    }

    public void setData(List<ShowBean> data) {
        this.data = data;
    }
}

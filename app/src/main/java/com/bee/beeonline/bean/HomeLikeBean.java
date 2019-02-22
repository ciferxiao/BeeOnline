package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class HomeLikeBean extends BaseData {
    private HomeLikeBase data;

    public HomeLikeBase getData() {
        return data;
    }

    public void setData(HomeLikeBase data) {
        this.data = data;
    }

    public class HomeLikeBase {
        private List<HomeDataBean.Like> data;

        public List<HomeDataBean.Like> getData() {
            return data;
        }

        public void setData(List<HomeDataBean.Like> data) {
            this.data = data;
        }
    }


}

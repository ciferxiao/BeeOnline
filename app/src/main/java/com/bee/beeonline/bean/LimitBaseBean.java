package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class LimitBaseBean extends BaseData {

    private LimitBase data;

    public LimitBase getData() {
        return data;
    }

    public void setData(LimitBase data) {
        this.data = data;
    }

    public class LimitBase {
        private List<LimitInfo> info;
        private List<LimitBean> data;
        public List<LimitInfo> getInfo() {
            return info;
        }

        public void setInfo(List<LimitInfo> info) {
            this.info = info;
        }

        public List<LimitBean> getData() {
            return data;
        }

        public void setData(List<LimitBean> data) {
            this.data = data;
        }
    }


}

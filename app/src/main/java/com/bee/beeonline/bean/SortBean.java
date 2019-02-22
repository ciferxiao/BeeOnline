package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class SortBean extends BaseData {
    private SortDataBean data;

    public SortDataBean getData() {
        return data;
    }

    public void setData(SortDataBean data) {
        this.data = data;
    }

    public class SortDataBean {
        private List<EffectBrandsBean> brands;
        private List<EffectBean> effect;

        public List<EffectBrandsBean> getBrands() {
            return brands;
        }

        public void setBrands(List<EffectBrandsBean> brands) {
            this.brands = brands;
        }

        public List<EffectBean> getEffect() {
            return effect;
        }

        public void setEffect(List<EffectBean> effect) {
            this.effect = effect;
        }
    }
}

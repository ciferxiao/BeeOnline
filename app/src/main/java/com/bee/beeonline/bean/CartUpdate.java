package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

public class CartUpdate extends BaseData {
    private CartUpdateData data;

    public CartUpdateData getData() {
        return data;
    }

    public void setData(CartUpdateData data) {
        this.data = data;
    }

    public class CartUpdateData{
        private String total_price;
        private int total_number;

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public int getTotal_number() {
            return total_number;
        }

        public void setTotal_number(int total_number) {
            this.total_number = total_number;
        }
    }
}

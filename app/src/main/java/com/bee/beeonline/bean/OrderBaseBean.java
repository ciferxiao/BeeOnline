package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class OrderBaseBean extends BaseData {

    private OrderBase data;

    public OrderBase getData() {
        return data;
    }

    public void setData(OrderBase data) {
        this.data = data;
    }

    public class OrderBase {
        private List<OrderBean> orders;

        public List<OrderBean> getOrders() {
            return orders;
        }

        public void setOrders(List<OrderBean> orders) {
            this.orders = orders;
        }
    }
}

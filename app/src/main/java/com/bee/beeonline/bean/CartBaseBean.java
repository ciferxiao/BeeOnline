package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.util.List;

public class CartBaseBean extends BaseData {

    private CartBase data;

    public CartBase getData() {
        return data;
    }

    public void setData(CartBase data) {
        this.data = data;
    }

    public class CartBase {
        private List<CartBean> cart;

        public List<CartBean> getCart() {
            return cart;
        }

        public void setCart(List<CartBean> cart) {
            this.cart = cart;
        }
    }
}

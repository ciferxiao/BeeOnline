package com.bee.beeonline.bean;

public class EffectBean {
    private int goods_attr_id;
    private int goods_id;
    private int attr_id;
    private String attr_value;
    private String attr_price;
    private boolean isCheck=false;


    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getGoods_attr_id() {
        return goods_attr_id;
    }

    public void setGoods_attr_id(int goods_attr_id) {
        this.goods_attr_id = goods_attr_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public String getAttr_value() {
        return attr_value;
    }

    public void setAttr_value(String attr_value) {
        this.attr_value = attr_value;
    }

    public String getAttr_price() {
        return attr_price;
    }

    public void setAttr_price(String attr_price) {
        this.attr_price = attr_price;
    }
}

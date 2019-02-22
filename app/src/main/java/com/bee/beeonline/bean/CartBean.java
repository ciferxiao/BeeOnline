package com.bee.beeonline.bean;

public class CartBean {
    private int goods_id;
    private String goods_price;
    private int goods_number;
    private int selected;
    private int is_wholesale;
    private long add_time;
    private int id;
    private int amount;
    private String property;
    private int price;
    private int attr_stock;
    private String attrs;

    private HomeDataBean.Like product;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public int getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(int goods_number) {
        this.goods_number = goods_number;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getIs_wholesale() {
        return is_wholesale;
    }

    public void setIs_wholesale(int is_wholesale) {
        this.is_wholesale = is_wholesale;
    }

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAttr_stock() {
        return attr_stock;
    }

    public void setAttr_stock(int attr_stock) {
        this.attr_stock = attr_stock;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }

    public HomeDataBean.Like getProduct() {
        return product;
    }

    public void setProduct(HomeDataBean.Like product) {
        this.product = product;
    }
}

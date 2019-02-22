package com.bee.beeonline.bean;

import java.util.List;

public class Goods {
    private int rec_id;
    private String market_price;
    private String goods_price;
    private String discount_fee;
    private String cost_price;
    private int id;
    private Product product;
    private String property;
    private String attachment;
    private int amount;
    private String total_price;
    private String product_price;
    private boolean is_reviewed;
    private WeightBean goods_weight;
    private String refund_info;
    private List<GoodSpro> goodspro;

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getDiscount_fee() {
        return discount_fee;
    }

    public void setDiscount_fee(String discount_fee) {
        this.discount_fee = discount_fee;
    }

    public String getCost_price() {
        return cost_price;
    }

    public void setCost_price(String cost_price) {
        this.cost_price = cost_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public boolean isIs_reviewed() {
        return is_reviewed;
    }

    public void setIs_reviewed(boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
    }

    public WeightBean getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(WeightBean goods_weight) {
        this.goods_weight = goods_weight;
    }

    public String getRefund_info() {
        return refund_info;
    }

    public void setRefund_info(String refund_info) {
        this.refund_info = refund_info;
    }

    public List<GoodSpro> getGoodspro() {
        return goodspro;
    }

    public void setGoodspro(List<GoodSpro> goodspro) {
        this.goodspro = goodspro;
    }
}

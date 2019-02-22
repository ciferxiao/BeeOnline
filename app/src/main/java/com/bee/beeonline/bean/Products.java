package com.bee.beeonline.bean;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {

    private Integer goods_id;
    private Integer act_id;
    private String act_name;
    private String price;
    private String promote_price;
    private String start_time;
    private String end_time;
    private List<Avatar> photos;
    private Avatar default_photo;


    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getAct_id() {
        return act_id;
    }

    public void setAct_id(Integer act_id) {
        this.act_id = act_id;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(String promote_price) {
        this.promote_price = promote_price;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public List<Avatar> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Avatar> photos) {
        this.photos = photos;
    }

    public Avatar getDefault_photo() {
        return default_photo;
    }

    public void setDefault_photo(Avatar default_photo) {
        this.default_photo = default_photo;
    }
}

package com.bee.beeonline.bean;

public class Carousel {
    private Integer ca_id;
    private Integer sort_order;
    private Integer is_display;
    private Avatar url;
    private Integer app_type;
    private Integer type;

    public Integer getCa_id() {
        return ca_id;
    }

    public void setCa_id(Integer ca_id) {
        this.ca_id = ca_id;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public Integer getIs_display() {
        return is_display;
    }

    public void setIs_display(Integer is_display) {
        this.is_display = is_display;
    }

    public Avatar getUrl() {
        return url;
    }

    public void setUrl(Avatar url) {
        this.url = url;
    }

    public Integer getApp_type() {
        return app_type;
    }

    public void setApp_type(Integer app_type) {
        this.app_type = app_type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

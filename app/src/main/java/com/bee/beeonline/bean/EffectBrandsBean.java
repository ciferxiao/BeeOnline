package com.bee.beeonline.bean;

public class EffectBrandsBean {
    private int brand_id;
    private String brand_name;
    private String brand_logo;
    private String brand_logo2;
    private String brand_desc;
    private String site_url;
    private int sort_order;
    private int is_show;
    private String brand_from;
    private String brand_from_logo;
    private String cover;
    private boolean isCheck = false;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_logo() {
        return brand_logo;
    }

    public void setBrand_logo(String brand_logo) {
        this.brand_logo = brand_logo;
    }

    public String getBrand_logo2() {
        return brand_logo2;
    }

    public void setBrand_logo2(String brand_logo2) {
        this.brand_logo2 = brand_logo2;
    }

    public String getBrand_desc() {
        return brand_desc;
    }

    public void setBrand_desc(String brand_desc) {
        this.brand_desc = brand_desc;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public String getBrand_from() {
        return brand_from;
    }

    public void setBrand_from(String brand_from) {
        this.brand_from = brand_from;
    }

    public String getBrand_from_logo() {
        return brand_from_logo;
    }

    public void setBrand_from_logo(String brand_from_logo) {
        this.brand_from_logo = brand_from_logo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}

package com.bee.beeonline.bean;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private String price;
    private String title;
    private List<Avatar> photos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Avatar> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Avatar> photos) {
        this.photos = photos;
    }
}

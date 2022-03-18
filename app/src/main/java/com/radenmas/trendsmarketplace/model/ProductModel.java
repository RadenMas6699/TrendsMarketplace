package com.radenmas.trendsmarketplace.model;

public class ProductModel {

    String title, desc, img, url;

    public ProductModel() {
    }

    public ProductModel(String title, String desc, String img, String url) {
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.example.ecommerceproject;

public class itemsnames {
    String img;
    String title;
    String collection;



    public itemsnames() {
    }

    public itemsnames(String img,String title,String collection) {
        this.img=img;
        this.title=title;
        this.collection=collection;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

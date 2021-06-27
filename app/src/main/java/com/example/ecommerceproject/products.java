package com.example.ecommerceproject;

import java.io.Serializable;

public class products implements Serializable {

    String name;
    String image;
    int price;

    public products() {
    }

    public products(String name,String image,int price) {
        this.name=name;
        this.image=image;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

package com.example.ecommerceproject;

import java.io.Serializable;

public class allproducts implements Serializable {
    String i;
    String n;
    int p;

    public allproducts() {
    }

    public allproducts(String i,String n,int p) {
        this.i = i;
        this.n = n;
        this.p = p;

    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}

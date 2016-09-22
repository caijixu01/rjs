package com.cjx.rjs.model;

import com.cjx.rjs.model.base.Base2PO;

@SuppressWarnings("serial")
public class Dog extends Base2PO {

    private String dogAttr;

    public String getDogAttr() {
        return dogAttr;
    }

    public void setDogAttr(String dogAttr) {
        this.dogAttr = dogAttr;
    }
}
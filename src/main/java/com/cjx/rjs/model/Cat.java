package com.cjx.rjs.model;

import com.cjx.rjs.model.base.Base2PO;

@SuppressWarnings("serial")
public class Cat extends Base2PO {

    private String catAttr;

    public String getCatAttr() {
        return catAttr;
    }

    public void setCatAttr(String catAttr) {
        this.catAttr = catAttr;
    }
}
package com.cjx.rjs.vo.cat;

import com.cjx.rjs.vo.base.BaseVO;

@SuppressWarnings("serial")
public class CatVO extends BaseVO {

    private String catAttr;

    public String getCatAttr() {
        return catAttr;
    }

    public void setCatAttr(String catAttr) {
        this.catAttr = catAttr;
    }
}
package com.cjx.rjs.vo.dog;

import com.cjx.rjs.vo.base.BaseVO;

@SuppressWarnings("serial")
public class DogVO extends BaseVO {

    private String dogAttr;

    public String getDogAttr() {
        return dogAttr;
    }

    public void setDogAttr(String dogAttr) {
        this.dogAttr = dogAttr;
    }
}
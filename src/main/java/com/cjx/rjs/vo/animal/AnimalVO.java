package com.cjx.rjs.vo.animal;

import java.math.BigDecimal;
import java.util.Date;

import com.cjx.rjs.vo.base.BaseVO;

@SuppressWarnings("serial")
public class AnimalVO extends BaseVO {
    private Date birth;

    private BigDecimal weight;

    private String type;

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
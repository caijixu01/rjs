package com.cjx.rjs.model.base;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public abstract class BasePO implements Serializable {
    private Serializable id;

    private String status;

    private Date statusDate;

    private Date createDate;

    private String createUserId;

    private Date updateDate;

    private String updateUserId;

    private String remark;

    // ----------
    private boolean isPersistent;

    private Boolean isNewEntity;

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Transient
    public Boolean getIsNewEntity() {
        return this.isNewEntity != null ? this.isNewEntity
                : (this.getId() == null);
    }

    public void setIsNewEntity(Boolean isNewEntity) {
        this.isNewEntity = isNewEntity;
    }

    @Transient
    public boolean isPersistent() {
        return isPersistent;
    }

    public void setPersistent(boolean isPersistent) {
        this.isPersistent = isPersistent;
    }
}

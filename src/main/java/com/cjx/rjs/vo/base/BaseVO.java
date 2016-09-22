package com.cjx.rjs.vo.base;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * BaseVO
 * 
 * @author caijx
 */
@SuppressWarnings("serial")
public class BaseVO implements Serializable {
    private Serializable id;

    private String status;

    private Date statusDate;

    private Date createDate;

    private String createUserId;

    private Date updateDate;

    private String updateUserId;

    private String remark;
    
    // -- field begin--------------
    private String ids;
    private Serializable userId;
    
    /**
     * 请求查询的页码
     */
    private Integer pageNum;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 排序字段, 字段名/升降序
     */
    private Map<String, Integer> orderBy;
    // -- field end--------------
    
    // ## meothd begin #########################
    public Serializable getForeignKey() {
        return null;
    }
    public void setForeignKey(Serializable fkId) {
    }
    // ## meothd end #########################
    
    public Serializable getId() {
        return id;
    }

    public Serializable getUserId() {
        return userId;
    }


    public void setUserId(Serializable userId) {
        this.userId = userId;
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Integer> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Map<String, Integer> orderBy) {
        this.orderBy = orderBy;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}

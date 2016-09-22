package com.cjx.rjs.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 * 
 * @author caijx
 */
@SuppressWarnings("serial")
public class Page<T> implements Serializable {
	
	/**
	 * 第几页 
	 */
	private Integer pageNum;
	
	/**
	 * 每页几行 
	 */
	private Integer pageSize;
	
	/**
	 * 当前页开始行
	 */
	private Integer startRow;
    
    /**
     * 当前页结束行
     */
	private Integer endRow;
    
    /**
     * 总记录数
     */
	private Long totalRowCounts;
    
    /**
     * 总页数
     */
	private Long totalPageCounts;
    
    /**
     * 结果集
     */
	private List<T> list;
	
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
    public Integer getStartRow() {
        return startRow;
    }
    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
    public Integer getEndRow() {
        return endRow;
    }
    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }
    public Long getTotalRowCounts() {
        return totalRowCounts;
    }
    public void setTotalRowCounts(Long totalRowCounts) {
        this.totalRowCounts = totalRowCounts;
    }
    public Long getTotalPageCounts() {
        return totalPageCounts;
    }
    public void setTotalPageCounts(Long totalPageCounts) {
        this.totalPageCounts = totalPageCounts;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
}

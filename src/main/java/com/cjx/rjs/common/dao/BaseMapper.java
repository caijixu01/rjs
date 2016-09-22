package com.cjx.rjs.common.dao;

import java.io.Serializable;
import java.util.List;

import com.cjx.rjs.common.page.PageList;
import com.cjx.rjs.vo.base.BaseVO;

/**
 * mapper 基类
 * @author caijx
 * @param <P> po
 */
public interface BaseMapper<P> {
    int deleteByPrimaryKey(Serializable id);
    
    int insert(P po);

    int insertSelective(P po);

    P selectByPrimaryKey(Serializable id);

    int updateByPrimaryKeySelective(P po);

    int updateByPrimaryKey(P po);
    
    List<P> getAll(Object po);
    
    <V> PageList<V> queryPage(BaseVO po);
    
    <V> List<V> queryList(Object po);
    
}

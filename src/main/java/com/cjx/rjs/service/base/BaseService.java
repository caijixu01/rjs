package com.cjx.rjs.service.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjx.rjs.common.dao.BaseMapper;
import com.cjx.rjs.common.page.Page;
import com.cjx.rjs.common.page.PageList;
import com.cjx.rjs.common.page.PageUtil;
import com.cjx.rjs.model.base.BasePO;
import com.cjx.rjs.util.ReflectUtil;
import com.cjx.rjs.vo.base.BaseVO;

public abstract class BaseService<V, P extends BasePO> {
    @Autowired
    protected BaseMapper<P> mapper;
    
    protected P daoGet(Serializable id) {
        P po = this.mapper.selectByPrimaryKey(id);
        po.setPersistent(true);
        return po;
    }

    protected Serializable daoSave(P po) {
        if (po.getIsNewEntity()) {
            this.mapper.insert(po);
            po.setPersistent(true);
            po.setIsNewEntity(false);
        } else {
            if (po.isPersistent()) {
                this.mapper.updateByPrimaryKey(po);
            } else {
                this.mapper.updateByPrimaryKeySelective(po);
            }
        }
        return po.getId();
    }
    
    protected void daoDelete(Serializable id) {
        this.mapper.deleteByPrimaryKey(id);
    }
    
    protected final P newPo() {
        return ReflectUtil.newParameterizedTypeInstance(this, 1);
    }
    
    protected final V newVO() {
        return ReflectUtil.newParameterizedTypeInstance(this, 0);
    }
    
    public P get(Serializable id) {
        P po = this.daoGet(id);
        return po;
    }
    
    public List<P> getByForeignKey(Serializable id) {
        if (id == null) {
            return new ArrayList<P>();
        }
        
        P po = this.newPo();
        po.setId(id);
        return this.mapper.getAll(po);
    }

    public V query(Serializable id) {
        P po = this.daoGet(id);
        V vo = this.newVO();
        BeanUtils.copyProperties(po, vo);
        return vo;
    }
    
    public P save(V vo) {
        P po = this.newPo();
        BeanUtils.copyProperties(vo, po);
        return this.save(po);
    }
    
    public P save(P po) {
        this.daoSave(po);
        return po;
    }
    
    public void delete(Serializable id) {
        this.daoDelete(id);
    }
    
    public void deleteByIds(String ids) {
        for (String id : ids.split(",")) {
            this.delete(id);
        }
    }

    public List<V> queryList(Object reqVO) {
        return this.mapper.queryList(reqVO);
    }
    
    public Page<V> queryPage(BaseVO reqVO) {
        PageList<V> pageList = this.mapper.queryPage(reqVO);
        return PageUtil.toPage(pageList);
    }
    
    public Page<V> queryPageByForeignKey(BaseVO reqVO) {
        if (reqVO.getForeignKey() == null) {
            return null;
        }
        
        BaseVO baseVO = new BaseVO();
        baseVO.setForeignKey(reqVO.getForeignKey());
        return this.queryPage(baseVO);
    }

}

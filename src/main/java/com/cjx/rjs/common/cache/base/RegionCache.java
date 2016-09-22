package com.cjx.rjs.common.cache.base;

/**
 * 地区 缓存
 * 
 * @author caijx
 */
public class RegionCache extends StringCache {
    
    public RegionCache() {
    }
    
    protected void config() {
        this.maximumSize = 20000;
    }

    protected void preload() {
    }
    
    protected String loadByKey(String key) {
        return "" + System.currentTimeMillis();
    }

}

package com.cjx.rjs.common.cache.base;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 缓存 基类
 * @author caijx
 */
public abstract class BaseCache<K, V> {
    /**
     * 最大缓存数
     */
    protected long maximumSize = 10000;
    
    /**
     * store
     */
    private LoadingCache<K, V> store = null;
    
    public BaseCache() {
        this.config();
    }
    
    /**
     * cache 参数 配置
     * . 
     */
    protected void config() {
    }
    
    /**
     * 预加载
     * . 
     */
    protected void preload() {
    }
    
    /**
     * build
     * . 
     */
    public BaseCache<K, V> build() {
        this.store = CacheBuilder.newBuilder()
                .maximumSize(this.maximumSize)
//                .expireAfterAccess(333, TimeUnit.SECONDS)
//                .expireAfterWrite(333, TimeUnit.SECONDS)
                .build(new CacheLoader<K, V>() {
                    @Override
                    public V load(K key) throws Exception {
                        return loadByKey(key);
                    }
                });
        
        this.preload();
        
        return this;
    }

    /**
     * 加载By Key
     * .
     */
    protected abstract V loadByKey(K key);

    /**
     * get
     */
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        if (key != null) {
            try {
                return this.store.get((K) key);
            } catch (ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        
        return null;
    }
    
    public V put(K key, V value) {
        this.store.put(key, value);
        
        return null;
    }
}

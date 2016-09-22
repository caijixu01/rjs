package com.cjx.rjs.common.cache.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheFactory {
    private final static Map<Class<?>, BaseCache<?, ?>> CACHE_MAP = new ConcurrentHashMap<Class<?>, BaseCache<?, ?>>();

    @SuppressWarnings("unchecked")
    public static <C extends BaseCache<?, ?>> C getCache(Class<C> clz) {
        C baseCache = (C) CACHE_MAP.get(clz);

        if (baseCache == null) {
            C c = null;
            try {
                c = clz.newInstance();
                c.build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            CACHE_MAP.put(clz, c);
            baseCache = c;
        }

        return baseCache;
    }

}

package com.cjx.rjs.util;

import java.lang.reflect.ParameterizedType;

public class ReflectUtil {
    @SuppressWarnings("unchecked")
    public static <T> T newParameterizedTypeInstance(Object o, int pi) {
        try {
            ParameterizedType parameterizedType = (ParameterizedType)o.getClass().getGenericSuperclass(); 
            Class<?> clz2 = (Class<?>) parameterizedType.getActualTypeArguments()[pi];
            Object o2 = clz2.newInstance();
            return (T) o2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static <T> T newParameterizedTypeInstance(Object o) {
        return newParameterizedTypeInstance(o, 0);
    }
}

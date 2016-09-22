package com.cjx.rjs.common.intercept;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.cjx.rjs.vo.base.BaseVO;

/**
 * dubbo服务拦截器
 * @author caijx
 */
@Aspect
@Component
public class ServiceAop {
    
    public ServiceAop() {
    }
    
    @Before("execution(* com.cjx.rjs..*Service.*(..)) && args(vo)")
    public void before(BaseVO vo) {
        System.out.println("Aop");
    }
}

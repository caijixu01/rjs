package com.cjx.rjs.common.intercept;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.cjx.rjs.vo.base.ResultVO;

/**
 * spring mvc 全局异常处理
 * 
 * @author caijx
 */
public class ServletExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(getClass());
    
    protected String getErrorViewName() {
        return "common/error";
    }

    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        logger.info(request.getRequestURI());
        ex.printStackTrace();
        
        Throwable rootException = ExceptionUtil.unwrapThrowable(ex);
        
        ResultVO<String> resultVO = ResultVO.newFailInstance();
        resultVO.setResultMessage(this.getExceptionMessage(rootException));
        resultVO.setValue(this.getExceptionInfo(rootException));
        
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();
        if (((HandlerMethod) handler).getMethod().getAnnotation(ResponseBody.class) != null) {
            MappingJackson2JsonView view = new MappingJackson2JsonView(); // 对应 resultVO
            map.put("success", false);
            map.put("resultMessage", resultVO.getResultMessage());
            map.put("value", resultVO.getValue());
            view.setAttributesMap(map);
            modelAndView.setView(view);
        } else {
            map.put("errorInfo", resultVO);
            return new ModelAndView(this.getErrorViewName(), map);
        }

        return modelAndView;
    }
    
    /**
     * 报异常的方法位置
     * .
     */
    protected String getExceptionInfo(Throwable e) {
        try {
            String exceptionInfo = null;
            // 取本地工程的类名
            if (e instanceof NullPointerException) {
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    if (stackTraceElement.getClassName().startsWith("com.ai.ctos")) {
                        exceptionInfo = stackTraceElement + "";
                        break;
                    }
                }
            } else if (e instanceof RuntimeException) {
                exceptionInfo = this.getGroup(e.getMessage(), "\\s*at\\s*(com\\.ai\\.ctos[^\n]*)\n", 1);
            }
            
            if (exceptionInfo == null) {
                return e.getStackTrace()[0] + ""; // 开源代码不做处理
            } else {
                // 返回: 方法(类:行)
                return this.getGroup(exceptionInfo, "\\.([^.]+\\(.+\\))", 1); // 本地工程代码, 返回: 方法(类:行)
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return e2.getMessage();
        }
    }
    
    /**
     * 异常详情, e.getMessage()
     * .
     */
    protected String getExceptionMessage(Throwable e) {
        try {
            if (e instanceof DataAccessException) {
                return "数据库异常";
            } else if (e instanceof NullPointerException) {
                return "空指针异常";
            } else if (e instanceof RuntimeException) {
                String msg = this.getGroup(e.getMessage(), "([^\n]*):\\s*([^\n]*)\n", 2);
                if (msg != null) {
                    return msg;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        
        return "系统异常";
    }
    
    private String getGroup(String str, String regx, int groupIdx) {
        if (str != null) {
            try {
                Matcher m = Pattern.compile(regx).matcher(str);
                if (m.find()) {
                    return m.group(groupIdx);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
}
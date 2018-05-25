package com.example.headerannotation.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求头拦截器,要求必须具备员工id.
 * 后续可以加上查找数据库的操作,从数据库中查找到员工则放行.
 */
@Component("headerInterceptor")
public class HeaderInterceptor  implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String eId = request.getHeader("eId");
        LOGGER.info("请求头是否包含eId:{}",eId);
        return !StringUtils.isEmpty(eId);

    }
}

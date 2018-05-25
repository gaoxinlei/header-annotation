package com.example.headerannotation.config;

import com.example.headerannotation.interceptor.HeaderInterceptor;
import com.example.headerannotation.resolver.EmployeeResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置类.
 * 用于配置本示例使用到的拦截器和解析器.
 * 保证若请求header中没有eId,则拦截.
 * 若请求中有eId则放行,且若controler参数中标有@Employee注解,则将其注入.
 */
@Configuration
public class EmployeeConfig implements WebMvcConfigurer {

    @Resource
    private HeaderInterceptor headerInterceptor;

    @Resource
    private EmployeeResolver employeeResolver;


    //添加拦截器.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor).excludePathPatterns("/employee/test");
    }

    //添加参数解析器.
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(employeeResolver);
    }
}

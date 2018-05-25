package com.example.headerannotation.resolver;

import com.example.headerannotation.annotation.EmployeeHeader;
import com.example.headerannotation.model.Employee;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * employee参数解析器.
 * 用于将注解@Employee自动注入控制器形参.
 * 注入只需满足一定条件,不一定使用注解标注来判断.
 */
@Component("employeeResolver")
public class EmployeeResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(EmployeeHeader.class)!=null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        EmployeeHeader annotation = parameter.getParameterAnnotation(EmployeeHeader.class);
        if(null!=annotation){
            HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
            String eId = request.getHeader("eId");
            Employee employee = new Employee();
            employee.setEmployeeId(eId);
            return  employee;
        }

        return null;
    }
}

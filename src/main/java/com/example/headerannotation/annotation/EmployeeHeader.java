package com.example.headerannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解标识.
 * 参数注入不一定非要使用注解.
 * 但如果使用本注解,一定要标上修饰范围为参数,有效其达到运行时.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeHeader {
}

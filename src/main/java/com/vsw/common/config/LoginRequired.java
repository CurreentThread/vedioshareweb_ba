package com.vsw.common.config;


import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;


//作用于方法上
@Target({ElementType . METHOD})
//注解运行时有效
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface LoginRequired {
}

package com.whynotyue.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解，声明「只有登录才能访问」
// @Target 声明自定义注解作用位置，ElementType.METHOD 作用方法上
// @Retention 声明自定义注解有效时间，RetentionPolicy.RUNTIME 程序运行时有效
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {

}

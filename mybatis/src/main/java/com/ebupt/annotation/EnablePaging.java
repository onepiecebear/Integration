package com.ebupt.annotation;

import java.lang.annotation.*;

/**
 * @Author: yushibo
 * @Date: 2019/5/3 0003 14:59
 * @Description: 自定义pagehelper分页注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnablePaging {

    String value()  default "";
}

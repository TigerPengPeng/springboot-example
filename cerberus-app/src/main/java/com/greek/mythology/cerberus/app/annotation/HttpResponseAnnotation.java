/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HttpResponseAnnotation {
}

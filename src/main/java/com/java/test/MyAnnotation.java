package com.java.test;

/**
 * Created by wendyhe on 2019/6/29.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * MyAnnotation是自定义个一个Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
}

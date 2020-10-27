package com.iwanvi.bigdata.inter.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解（目前仅添加字段描述使用）
 *
 * @author zhj
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomTag {
    // 字段的描述
    String desc();
}
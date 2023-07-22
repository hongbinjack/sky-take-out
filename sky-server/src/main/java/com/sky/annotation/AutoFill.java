package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：用于标识某个方法需要进行功能字段自动填充处理
 *
 * 在Spring框架中，@Target(ElementType.METHOD)和@Retention(RetentionPolicy.RUNTIME)是两个常用的注解，分别用于定义方法的可用范围和注解的生命周期。
 *
 * @Target(ElementType.METHOD)注解指定了该注解可以应用的目标元素类型，这里是METHOD，表示该注解可以应用于方法上。
 * 这意味着只有被该注解标记的方法才会受到注解的影响。
 *
 * @Retention(RetentionPolicy.RUNTIME)注解指定了注解的生命周期，这里是RUNTIME，表示该注解将在运行时保留，可以
 * 通过反射机制在运行时获取和处理这个注解。这意味着在程序运行期间，可以通过反射获取被该注解标记的方法，并进行相应的处理。
 *
 * 综合起来，@Target(ElementType.METHOD)和@Retention(RetentionPolicy.RUNTIME)这两个注解的组合表示，被标注
 * 的注解可以应用于方法上，并且可以在运行时通过反射获取和处理。在Spring框架中，这样的注解通常用于定义切面、拦截器、事务等与方法相关的功能
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    // 数据库操作类型： UPDATE    INSERT
    OperationType value();
}

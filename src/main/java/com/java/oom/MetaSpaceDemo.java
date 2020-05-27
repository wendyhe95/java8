package com.java.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: 95
 * @Date: 2020/5/26
 *
 * JVM参数
 * -XX:MetaspaceSize=5m -XX:MaxMetaspaceSize
 *
 * Java 8及之后的版本使用Metaspace代替永久代
 *
 * Metaspace是方法区在HotSpot中的实现，它和永久代最大的区别在于：MaxMetaspace并不在虚拟机中，而是使用本机内存
 *
 * 永久代(java8 后被MaxMetaspace取代)存储了以下信息：
 * 虚拟机加载的类信息
 * 常量池
 * 静态变量
 * 即时编译后的代码
 *
 * 模拟Metaspace空间溢出 不断生成类给Metaspace里灌 类占据的空间总是会超过Metaspace指定的空间大小
 */
public class MetaSpaceDemo {

    static class OOMTest{ }
    public static void main(String[] args) {

        int i =0;
        try {
            i++;
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });
            enhancer.create();
        }catch (Throwable e){
            System.out.println("===========多少次后发生了异常："+i);
            e.printStackTrace();
        }
    }
}

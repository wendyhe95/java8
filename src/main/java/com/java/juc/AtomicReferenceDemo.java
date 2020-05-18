package com.java.juc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User{
    String userName;
    int age;
}
/**
 * @Author: 95
 * @Date: 2020/5/16
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User z3 = new User("zhangsan",22);
        User li4 = new User("lisi",25);

        AtomicReference<User> atomicReference = new AtomicReference<User>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t "+ atomicReference.get().toString() );
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t "+ atomicReference.get().toString() );
    }
}

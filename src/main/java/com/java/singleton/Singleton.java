package com.java.singleton;

/**
 * @Author: 95
 * @Date: 2020/5/11
 */

/**
 * 饿汉式：在类初始化时直接创建实例对象，不论你是否需要这个对象
 *
 *  1.构造器私有化
 *  2.自行创建，并且用静态变量保存
 *  3.向外提供这个实例
 *  4.强调这是一个实例，我们可以用final修改
 *
 *  这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * 它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
 */
//public class Singleton {
//    public static final Singleton INSTANCE = new Singleton();
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        return INSTANCE;
//    }
//}

/**
 * 懒汉式：
 *
 *  1.构造器私有化
 *  2.静态变量保存唯一的实例
 *  3.提供一个静态方法获取实例对象
 *
 *  这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 *  这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
//public class Singleton {
//    private static  Singleton instance;
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        if(instance == null){
//          instance = new Singleton();
//        }
//        return  instance;
//    }

/**
 *  DCL  double check lock 双端检锁
 *  这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 *  getInstance() 的性能对应用程序很关键。
 *
 *  DCL机制不一定线程安全，因为有指令重排序的存在，加入volatile可以禁止指令重排
 *  某一个线程在执行到第一次检测时，读取到的instance不为null，instance的引用对象可能没有完成初始化
 */
public class Singleton {
    private static  volatile Singleton instance;

    private Singleton(){
        System.out.println(Thread.currentThread().getName()+"\t 构造方法================");
    }

    // DCL  double check lock 双端检锁
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return  instance;
    }



    public static void main(String[] args) {
//        // main线程
//        System.out.println(Singleton.getInstance() == Singleton.getInstance());
//        System.out.println(Singleton.getInstance() == Singleton.getInstance());
//        System.out.println(Singleton.getInstance() == Singleton.getInstance());

        // 并发多线程
        for (int i = 1; i <= 10; i++) {

            new Thread(() -> {
                Singleton.getInstance();
            },String.valueOf(i)).start();
        }
    }
}

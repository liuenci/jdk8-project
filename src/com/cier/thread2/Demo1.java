package com.cier.thread2;

/**
 * 单例设计模式：保证类在内存中只有一个对象
 * 1. 饿汉式是空间换时间，懒汉式是时间换空间
 * 2. 在多线程访问时，饿汉式不会创建多个对象，而饿汉式有可能会创建多个对象
 */
public class Demo1 {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.singleton;
        Singleton singleton2 = Singleton.singleton;
        System.out.println(singleton1 == singleton2);
    }
}

/**
 * 饿汉式
 */
/*class Singleton {
    // 1. 私有构造方法,其他类不能访问该构造方法
    private Singleton() {

    }

    // 2. 创建本类对象
    private static Singleton singleton = new Singleton();

    // 3. 对外提供公共访问方法
    public static Singleton getInstance() {
        return singleton;
    }
}*/

/**
 * 懒汉式,单例的延迟加载模式
 */
/*class Singleton {
    // 1. 私有构造方法,其他类不能访问该构造方法
    private Singleton() {

    }

    // 2. 申明一个引用
    private static Singleton singleton;

    // 3. 对外提供公共访问方法
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}*/

class Singleton {
    // 1. 私有构造方法,其他类不能访问该构造方法
    private Singleton() {

    }

    // 2. 申明一个引用
    public static final Singleton singleton = new Singleton();
}
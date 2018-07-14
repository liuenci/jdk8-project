package com.cier.factorymethod;

import com.cier.factory.Dog;

/**
 * 工厂方法
 * 后期维护容易，增强了系统的扩展性
 */
public class Test {

    public static void main(String[] args) {
        CatFactory catFactory = new CatFactory();
        Dog dog = (Dog) catFactory.createAnimal();
        dog.eat();
    }
}

package com.cier.factory;

public class Test {

    public static void main(String[] args) {
        Dog dog = (Dog) AnimalFactory.createAnimal("dog");
        dog.eat();

        Cat cat = (Cat) AnimalFactory.createAnimal("cat");
        cat.eat();
    }
}

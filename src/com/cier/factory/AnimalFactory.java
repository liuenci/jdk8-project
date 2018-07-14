package com.cier.factory;

public class AnimalFactory {
    // 这种方式复用性会太差
    /*public static Dog createDag(){
        return new Dog();
    }

    public static Cat createCat(){
        return new Cat();
    }*/
    // 这种方式不利于后期的维护
    public static Animal createAnimal(String name) {
        if ("dog".equals(name)){
            return new Dog();
        } else if ("cat".equals(name)) {
            return new Cat();
        } else {
            return null;
        }
    }
}

package com.cier.factorymethod;

import com.cier.factory.Animal;
import com.cier.factory.Dog;

public class CatFactory implements Factory {

    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

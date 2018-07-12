package com.cier.io;

import com.cier.pojo.Person;

import java.io.*;
import java.util.ArrayList;

public class Demo4 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream("f.txt"));
        ArrayList<Person> list = (ArrayList<Person>) objectOutputStream.readObject();
        list.stream().forEach(System.out::println);
        objectOutputStream.close();
    }
    /**
     * 序列化：将对象写到文件上
     */
    public static void demo1() throws IOException {
        Person person1 = new Person("张三", 23);
        Person person2 = new Person("李四", 24);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e.txt"));
        objectOutputStream.writeObject(person1);
        objectOutputStream.writeObject(person2);

        objectOutputStream.close();

    }
}

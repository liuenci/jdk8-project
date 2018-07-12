package com.cier.io;

import com.cier.pojo.Person;

import java.io.*;

public class Demo4 {
    /**
     * 序列化：将对象写到文件上
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Person person1 = new Person("张三", 23);
        Person person2 = new Person("李四", 24);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e.txt"));
        objectOutputStream.writeObject(person1);
        objectOutputStream.writeObject(person2);

        objectOutputStream.close();

    }
}

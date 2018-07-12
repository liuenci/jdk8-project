package com.cier.io;

import com.cier.pojo.Person;

import java.io.*;
import java.util.ArrayList;

public class Demo5 {


    public static void main(String[] args) throws IOException {
        Person person1 = new Person("张三",23);
        Person person2 = new Person("李四",24);
        Person person3 = new Person("王五",24);
        Person person4 = new Person("赵六",25);

        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("f.txt"));
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }

    public static void demo1() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e.txt"));

        Person person1 = (Person) objectInputStream.readObject();
        Person person2 = (Person) objectInputStream.readObject();
        // java.io.EOFException End Of File
        // Person person3 = (Person) objectInputStream.readObject();

        System.out.println(person1);
        System.out.println(person2);

        objectInputStream.close();
    }
}

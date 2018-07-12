package com.cier.io;

import com.cier.pojo.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Demo7 {

    public static void main(String[] args) throws IOException{
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("k.txt"),true);
        // 自动刷出的方法只针对的是 println 方法
        printWriter.println(97);
        printWriter.print(97);
        printWriter.write(97);
        // printWriter.close();
    }

    public static void demo1() {
        System.out.println("aaa");
        // 获取标准输出流
        PrintStream printStream = System.out;
        // 底层通过 Integer.toString() 将 97 转换成字符串并打印
        printStream.println(97);
        // 查找码表，找到对应的 a 并打印
        printStream.write(97);
        printStream.println();
        Person person = new Person("张三",23);
        // PrintStream 可以直接将对象的 toString() 方法打印
        printStream.println(person);
        printStream.close();
    }
}

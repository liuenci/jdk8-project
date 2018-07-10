package com.cier.reader;

import java.io.FileReader;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        demo1();
        /*FileReader fileReader = new FileReader("hello.txt");
        int c;
        // 通过项目的码表一次读取一个字节
        while ((c = fileReader.read()) != -1){
            System.out.print((char)c);
        }*/
    }

    /**
     * FileReader 每次都是读取一个字符
     * @throws IOException
     */
    public static void demo1() throws IOException {
        FileReader fileReader = new FileReader("hello.txt");
        int x = fileReader.read();
        System.out.println(x);
        char c = (char)x;
        System.out.println(c);
        x = fileReader.read();
        c = (char)x;
        System.out.println(c);
        fileReader.close();
    }
}

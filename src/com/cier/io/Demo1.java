package com.cier.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 序列流可以将多个流整合成一个流
 */
public class Demo1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream("a.txt");
        FileInputStream fileInputStream2 = new FileInputStream("b.txt");
        FileInputStream fileInputStream3 = new FileInputStream("c.txt");
        Vector<FileInputStream> vector = new Vector<>();
        vector.add(fileInputStream1);
        vector.add(fileInputStream2);
        vector.add(fileInputStream3);
        Enumeration<FileInputStream> enumeration = vector.elements();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
        FileOutputStream fileOutputStream = new FileOutputStream("d.txt");


        int b;
        while ((b = sequenceInputStream.read()) != -1) {
            fileOutputStream.write(b);
        }
        sequenceInputStream.close();
        fileInputStream1.close();
    }

    public static void demo2() throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream("a.txt");
        FileInputStream fileInputStream2 = new FileInputStream("b.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1, fileInputStream2);
        FileOutputStream fileOutputStream = new FileOutputStream("c.txt");
        int b;
        while ((b = sequenceInputStream.read()) != -1) {
            fileOutputStream.write(b);
        }
        // 序列流会在关闭的时候将构造方法中的流对象也关闭
        sequenceInputStream.close();
        fileOutputStream.close();
    }

    public static void demo1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("c.txt");

        int b1;
        while ((b1 = fileInputStream.read()) != -1) {
            fileOutputStream.write(b1);
        }
        fileInputStream.close();

        FileInputStream fileInputStream1 = new FileInputStream("b.txt");
        int b2;
        while ((b2 = fileInputStream1.read()) != -1) {
            fileOutputStream.write(b2);
        }
        fileInputStream1.close();
        fileOutputStream.close();

    }
}

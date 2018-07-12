package com.cier.io;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 内存输出流
 * FileInputStream 读取中文会乱码
 * 解决方案
 * 1. 字符流读取
 * 2. ByteArrayOutputStream
 */
public class Demo2 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        // 在内存中创建了可以自动增长的内存数组
        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();

        int b;
        while ((b = fileInputStream.read()) != -1) {
            byteArrayInputStream.write(b);
        }
        // 将缓冲区的数据全部获取出来，并赋值给 arr 数组,转成字符数组的好处是可以继续转化为其他的编码表
        byte[] arr = byteArrayInputStream.toByteArray();
        System.out.println(new String(arr));
        System.out.println(byteArrayInputStream.toString());
        fileInputStream.close();
        // 流关闭无效，集合数组直接在内存中进行操作，用完直接释放掉了，但是流是有管道的，从内存中连接硬盘进行读取的，用完就是需要关闭的。
//        byteArrayInputStream.close();
    }

    public static void demo1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        int a;
        while ((a = fileInputStream.read()) != -1) {
            System.out.println((char) a);
        }
        fileInputStream.close();
    }

}

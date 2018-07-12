package com.cier.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 定义一个文件输入流，调用 read(byte[] b) 方法，将 a.txt 文件中的内容打印出来(byte 数组大小限制为 5)
 *
 * 分析：
 * 1. 创建 FileInputStream ，关联 a.txt
 * 2. 创建字节数组，长度为 5
 * 3. 创建内存输出流，将读到的数据写到内存输出流中
 * 4. 将内存输出流的数据全部转换为字符串打印
 * 5. 关闭输入流
 */
public class Test5 {

    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arr = new byte[5];
        int len;
        while((len = fileInputStream.read(arr)) != -1){
            byteArrayOutputStream.write(arr,0,len);
        }
        System.out.println(byteArrayOutputStream);
        fileInputStream.close();
    }
}

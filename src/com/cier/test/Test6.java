package com.cier.test;
/**
 * 改变标准输入输出流进行图片拷贝
 */

import java.io.*;

public class Test6 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("logo1.png"));
        System.setOut(new PrintStream("copy.jpg"));

        InputStream inputStream = System.in;
        PrintStream printStream = System.out;

        byte[] arr = new byte[1024];
        int len;
        while ((len = inputStream.read(arr)) != -1){
            printStream.write(arr,0,len);
        }
        inputStream.close();
        printStream.close();
    }
}

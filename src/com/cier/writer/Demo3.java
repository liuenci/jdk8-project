package com.cier.writer;

import java.io.*;

public class Demo3 {

    public static void main(String[] args) throws IOException {
        // demo1();
        demo2();
    }

    public static void demo1() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("hello.txt"));
        String string;
        // 遇到 \r 或者 \n 就换行
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        bufferedReader.close();
    }

    public static void demo2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("hello.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hello4.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            // 两者的换行的区别是 前者是跨平台的方法 后者只支持 windows 系统
            bufferedWriter.newLine();
            bufferedWriter.write("\r\n");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}

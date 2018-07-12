package com.cier.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Demo8 {

    public static void main(String[] args) throws IOException {
        // 改变标准输入流
        System.setIn(new FileInputStream("a.txt"));
        // 改变标准输出流
        System.setOut(new PrintStream("b.txt"));
        // 获取标准的键盘输入流，默认指向键盘，改变后指向文件
        InputStream inputStream = System.in;
        // 获取标准输出流，默认是指向控制台，改变后就指向文件
        PrintStream printStream = System.out;

        int b;
        while ((b = inputStream.read()) != -1) {
            printStream.write(b);
        }
        inputStream.close();
        printStream.close();
    }

    public static void demo1() throws IOException {

        InputStream is = System.in;
        int x = is.read();
        System.out.println(x);
        is.close();
        // 只有一个流，及时重新创建也是一个流
        InputStream is2 = System.in;
        int y = is2.read();
        System.out.println(y);
    }
}

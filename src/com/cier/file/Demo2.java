package com.cier.file;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) {
        // demo1();
        // demo2();
    }

    public static void demo2() {
        File file = new File("file2");
        System.out.println(file.mkdir());
        // 文件夹也可以有后缀名
        File file1 = new File("file.txt");
        System.out.println(file1.mkdir());

        File file2 = new File("f/f/f");
        System.out.println(file2.mkdir());
        // 创建多级目录
        System.out.println(file2.mkdirs());
    }

    public static void demo1() throws IOException {
        File file = new File("file2.txt");
        // 如果没有这个文件就创建这个文件，如果有的话就不创建了
        System.out.println(file.createNewFile());
        // 没有后缀名也可以创建文件
        File file1 = new File("file");
        System.out.println(file1.exists());
    }
}

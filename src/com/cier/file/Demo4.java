package com.cier.file;

import java.io.File;

public class Demo4 {

    public static void main(String[] args) {
        File file = new File("file2.txt");
        file.setReadable(false);
        // windows 系统下所有文件都可读，linux 系统下面不可读。
        System.out.println(file.canRead());
        file.setWritable(false);
        // windows 系统下面可以设置不可写。
        System.out.println(file.canWrite());
        // 判断文件是否是隐藏
        System.out.println(file.isHidden());

    }

    public static void demo1(){
        File file = new File("f");
        // 判断是不是文件夹
        System.out.println(file.isDirectory());
        File file1 = new File("file2.txt");
        // 判读是不是文件
        System.out.println(file1.isFile());
    }
}

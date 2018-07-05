package com.cier.file;

import java.io.File;

public class Demo3 {

    public static void main(String[] args) {
        // 删除文件,不进入回收站
        File file = new File("file2.txt");
        System.out.println(file.delete());
        // 删除文件夹
        File file1 = new File("f/f/f");
        System.out.println(file1.delete());
        // 删除带文件夹的文件夹
        File file2 = new File("f");
        System.out.println(file2.delete());
    }
    public static void demo1() {
        File file = new File("file1.txt");
        File file1 = new File("file3.txt");
        // 重命名
        System.out.println(file.renameTo(file1));
        // 剪切
        File file2 = new File("D:\\file4.txt");
        System.out.println(file1.renameTo(file2));
    }
}

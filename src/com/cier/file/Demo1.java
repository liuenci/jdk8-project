package com.cier.file;

import java.io.File;

public class Demo1 {

    public static void main(String[] args) {
        // 绝对路径
        File file = new File("E:\\file");
        System.out.println(file.exists());

        // 相对路径
        File file1 = new File("file1.txt");
        System.out.println(file1.exists());

        // 父级路径和子级路径
        String parentsPath = "E:\\file";
        String childPath = "file.txt";
        File file2 = new File(parentsPath,childPath);
        System.out.println(file2.exists());

        // 父级路径对象和子级路径
        File file3 = new File(parentsPath);
        File file4 = new File(file3,childPath);
        System.out.println(file4.exists());

    }
}

package com.cier.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Demo5 {

    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects\\jdk8-project");
        // 获取每个文件夹底下的文件名称
        String[] dir = file.list();
        Arrays.stream(dir).forEach(System.out::println);
        // 获取每个文件夹底下的文件对象
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(e->System.out.println(e.getClass()));
    }
    public static void demo1(){
        File file = new File("file2.txt");
        File file1 = new File("E:\\IdeaProjects\\jdk8-project\\file2.txt");
        // 获取绝对路径
        System.out.println(file.getAbsolutePath());
        // 获取构造方法里面的路径
        System.out.println(file.getPath());
        // 获取文件的名称
        System.out.println(file.getName());
        System.out.println(file1.getName());
        // 获取文件内容的长度
        System.out.println(file.length());
        // 获取最后修改的毫秒值
        System.out.println(file.lastModified());
        Date date = new Date(file.lastModified());
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy月MM月dd日 HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }
}

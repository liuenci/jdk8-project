package com.cier.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * 判断某个文件夹下面是否有 .jpg 文件
 */
public class Demo6 {
    public static void main(String[] args) {
        File file = new File("E:/file");
        FilenameFilter filenameFilter = (dir, name) -> {
            File file1 = new File(dir,name);
            return file1.isFile()&&file1.getName().endsWith(".jpg");
        };
        String[] files = file.list(filenameFilter);
        Arrays.stream(files).forEach(System.out::println);
    }

    public static void demo1() {
        File file = new File("E:/file");
        String[] dir = file.list();
        Arrays.stream(dir).filter(e -> e.endsWith(".jpg")).forEach(System.out::println);

        File[] files = file.listFiles();
        Arrays.stream(files).filter(e -> e.isFile() && e.getName().endsWith(".jpg")).forEach(System.out::println);
    }
}

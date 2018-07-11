package com.cier.test;

import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test4 {
    /**
     * 需求：从键盘输入接收一个文件夹路径，打印出该文件夹下所有的 .java 文件名
     * 分析：
     * 从键盘接收一个文件夹路径
     * 1. 如果录入的是不存在的
     * 2. 如果录入的是文件路径
     * 3. 如果是文件夹路径，直接返回。
     * <p>
     * 打印出该文件夹下所有的 .java 文件名
     * 1. 获取到该文件夹路径下的所有的文件和文件夹，存储在 File 数组中
     * 2. 遍历数组，对每一个文件或者文件夹做判断
     * 3. 如果是文件，并且后缀是 .java 的，就打印
     * 4. 如果是文件夹，就递归调用
     *
     * @param args
     */
    public static void main(String[] args) {
        File dir = getDir();
        printJava(dir);
    }

    public static File getDir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径:");
        while (true) {
            String line = scanner.nextLine();
            File dir = new File(line);
            if (!dir.exists()) {
                System.out.println("路径不存在");
            } else if (dir.isFile()) {
                System.out.println("录入的文件路径，请录入文件夹路径");
            } else {
                return dir;
            }
        }
    }

    public static void printJava(File dir) {
        File[] subFiles = dir.listFiles();
        for (File subFile : subFiles) {
            if (subFile.isFile() && subFile.getName().endsWith(".java")) {
                System.out.println(subFile);
            } else if (subFile.isDirectory()) {
                printJava(subFile);
            }
        }
        // Stream.of(subFiles).filter(e->e.isFile()&&e.getName().endsWith(".java")).forEach(e->System.out.println(e));
    }
}

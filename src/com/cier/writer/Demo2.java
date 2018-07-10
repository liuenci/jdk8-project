package com.cier.writer;

import java.io.*;

public class Demo2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("hello.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hello3.txt"));

        int c;
        while ((c = bufferedReader.read()) != -1){
            bufferedWriter.write(c);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void demo3() throws IOException {
        FileReader fileReader = new FileReader("hello.txt");
        FileWriter fileWriter = new FileWriter("hello2.txt");

        char[] arr = new char[1024];
        int len;
        while ((len = fileReader.read(arr)) != -1){
            fileWriter.write(arr,0,len);
        }
        fileReader.close();
        fileWriter.close();
    }
    public static void demo2() throws IOException {
        // 不可以拷贝非纯文本的文件
        // 因为在读的时候会将字节转换为字符，在转换过程中，可能会找不到对应的字符，就会用 ？ 代替
        // 写出的时候会将字符转换为字节写出去
        // 如果是 ? ,直接写出，这样写出的文件就乱了。
        FileReader fileReader = new FileReader("logo1.png");
        FileWriter fileWriter = new FileWriter("logo2.png");

        int c;
        while ((c = fileReader.read()) != -1) {
            fileWriter.write(c);
        }
        fileReader.close();
        // 如果没有关流，数据都在缓冲区，数据无法写入,缓冲区大小为 2K = 1024 个字符 * 2，关闭流才会刷新
        fileWriter.close();
    }

    public static void demo1() throws IOException {
        FileReader fileReader = new FileReader("hello.txt");
        FileWriter fileWriter = new FileWriter("world.txt");

        int c;
        while ((c = fileReader.read()) != -1) {
            fileWriter.write(c);
        }
        fileReader.close();
        // 如果没有关流，数据都在缓冲区，数据无法写入,缓冲区大小为 2K = 1024 个字符 * 2，关闭流才会刷新
        fileWriter.close();
    }
}

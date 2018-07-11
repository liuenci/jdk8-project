package com.cier.test;

import java.io.*;
import java.util.ArrayList;

public class Test1 {
    /**
     * 将一个文本文档上的文本反转
     * 分析
     * 1. 创建输入输出流
     * 2. 创建集合对象
     * 3. 将读到的数据存储到集合中
     * 4. 倒着遍历集合将数据写到文件上
     * 5. 关闭流
     *
     * 注意：
     * 流对象尽量早开晚关
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("hello.txt"));

        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fz.txt"));
        for (int i = list.size() - 1; i >= 0; i--) {
            bufferedWriter.write(list.get(i));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}

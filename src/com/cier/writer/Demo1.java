package com.cier.writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        // 如果需要不清楚里面的数据，可以给构造方法里面加上 ture
        // FileWriter fileWriter = new FileWriter("hello.txt",true);
        FileWriter fileWriter = new FileWriter("hello.txt");
        fileWriter.write("大家好，我是渣渣辉");
        // 往里面写数字会直接变成数字对应的字符
        fileWriter.write(97);
        fileWriter.close();
    }
}

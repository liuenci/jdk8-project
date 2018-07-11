package com.cier.file;

import java.io.*;

public class Demo7 {


    public static void main(String[] args) throws IOException {
        // 更高效的读写
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("hello.txt"), "utf-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("GBK.txt"), "gbk"));
        int c;
        while ((c = bufferedReader.read()) != -1) {
            bufferedWriter.write(c);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void demo2() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("hello.txt"), "utf-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("GBK.txt"), "gbk");
        int c;
        while ((c = inputStreamReader.read()) != -1) {
            outputStreamWriter.write(c);
        }
        inputStreamReader.close();
        outputStreamWriter.close();
    }

    public static void demo1() throws IOException {
        FileReader fileReader = new FileReader("utf-8.txt");
        FileWriter fileWriter = new FileWriter("GBK.txt");

        int c;
        while ((c = fileReader.read()) != -1) {
            fileWriter.write(c);
        }
        fileReader.close();
        fileWriter.close();
    }
}

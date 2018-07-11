package com.cier.test;

import java.io.*;

public class Test3 {
    /**
     * 使用版软件如果没有购买正版，当执行一次会提示有多少次使用机会。
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 字节流读取
        /*FileInputStream fileInputStream = new FileInputStream("config.txt");
        int x = fileInputStream.read();
        System.out.println(x);*/

        // 字符流读取
        /*FileReader fileReader = new FileReader("config.txt");
        int x = fileReader.read();
        System.out.println(x);*/

        BufferedReader bufferedReader = new BufferedReader(new FileReader("config.txt"));
        String x = bufferedReader.readLine();
        if (Integer.parseInt(x) <= 0) {
            System.out.println("使用次数结束");
            bufferedReader.close();
            return;
        } else {
            System.out.println("您还有" + (Integer.parseInt(x) - 1) + "次使用机会");
            String num = String.valueOf(Integer.parseInt(x) - 1);
            FileWriter fileWriter = new FileWriter("config.txt");
            fileWriter.write(num);
            fileWriter.close();
        }

    }
}

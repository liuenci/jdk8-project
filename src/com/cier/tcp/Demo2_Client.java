package com.cier.tcp;


import java.io.*;
import java.net.Socket;

public class Demo2_Client {


    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1",12345);
        // 将字节流包装成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // PrintStream 中有写出换行的方法
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        System.out.println(bufferedReader.readLine());
        // 必须要有换行
        printStream.println("谢谢惠顾");
    }

    /*public static void demo1() throws IOException {

        Socket socket = new Socket("127.0.0.1",12345);
        // 将字节流包装成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // PrintStream 中有写出换行的方法
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        System.out.println(bufferedReader.readLine());
        // 必须要有换行
        printStream.println("谢谢惠顾");
    }*/


}

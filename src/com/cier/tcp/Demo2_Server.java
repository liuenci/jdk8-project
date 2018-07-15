package com.cier.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            // 接受客户端的请求
            Socket socket = serverSocket.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 将字节流包装成字符流
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        // PrintStream 中有写出换行的方法
                        PrintStream printStream = new PrintStream(socket.getOutputStream());

                        printStream.println("欢迎光临");
                        System.out.println(bufferedReader.readLine());
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static void demo1() throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        // 接受客户端的请求
        Socket socket = serverSocket.accept();

        // 将字节流包装成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // PrintStream 中有写出换行的方法
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        printStream.println("欢迎光临");
        System.out.println(bufferedReader.readLine());
        socket.close();
    }
}

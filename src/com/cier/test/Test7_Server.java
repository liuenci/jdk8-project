package com.cier.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test7_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("服务器启动");


        while (true) {
            Socket socket = serverSocket.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream printStream = new PrintStream(socket.getOutputStream());
                        // 将客户端的数据读取出来
                        String line = bufferedReader.readLine();
                        System.out.println(line);
                        // 链式编程
                        line = new StringBuilder(line).reverse().toString();
                        // 反转之后写回客户端
                        printStream.println(line);

                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        }
    }
}

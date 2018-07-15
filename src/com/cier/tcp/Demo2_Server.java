package com.cier.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        // 接受客户端的请求
        Socket socket = serverSocket.accept();
        /*// 获取客户端输入流
        InputStream inputStream = socket.getInputStream();
        // 获取客户端输出流
        OutputStream outputStream = socket.getOutputStream();
        // 服务器向客户端写出数据
        outputStream.write("百度一下，你就知道".getBytes());

        byte[] arr = new byte[1024];
        int len = inputStream.read(arr);*/


        // 将字节流包装成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // PrintStream 中有写出换行的方法
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        printStream.println("欢迎光临");
        System.out.println(bufferedReader.readLine());
        socket.close();

    }
}

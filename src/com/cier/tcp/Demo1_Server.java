package com.cier.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        // 接受客户端的请求
        Socket socket = serverSocket.accept();
        // 获取客户端输入流
        InputStream inputStream = socket.getInputStream();
        // 获取客户端输出流
        OutputStream outputStream = socket.getOutputStream();
        // 服务器向客户端写出数据
        outputStream.write("百度一下，你就知道".getBytes());

        byte[] arr = new byte[1024];
        int len = inputStream.read(arr);

        System.out.println(new String(arr,0,len));
    }
}

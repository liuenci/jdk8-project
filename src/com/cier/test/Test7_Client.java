package com.cier.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Test7_Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // 创建客户端，指定 IP 地址和端口号
        Socket socket = new Socket("127.0.0.1",12345);
        // 获取输入输出流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        // 将字符串写到服务器中去
        printStream.println(scanner.nextLine());

        // 将反转之后的结果写出来
        System.out.println(bufferedReader.readLine());
    }
}

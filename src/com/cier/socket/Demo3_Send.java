package com.cier.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo3_Send {
    public static void main(String[] args) throws IOException {
        // 可以不指定端口号
        DatagramSocket socket = new DatagramSocket();
        // 封装数据包，指定数据，长度，地址，端口
        // 创建键盘录入对象
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            if ("quit".equals(line)){
                break;
            }
            DatagramPacket packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
            // 发送数据包
            socket.send(packet);
        }
        socket.close();
    }
}

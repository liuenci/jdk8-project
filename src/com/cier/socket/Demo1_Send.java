package com.cier.socket;

import java.io.IOException;
import java.net.*;

public class Demo1_Send {
    public static void main(String[] args) throws IOException {
        // 可以不指定端口号
        DatagramSocket socket = new DatagramSocket();
        //  封装数据包，指定数据，长度，地址，端口
        String str = "hello world!";
        DatagramPacket packet = new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getByName("127.0.0.1"),6666);
        // 发送数据包
        socket.send(packet);
        socket.close();
    }
}

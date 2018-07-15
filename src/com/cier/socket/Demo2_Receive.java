package com.cier.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Demo2_Receive {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        while (true) {
            socket.receive(packet);
            // 从数据包里面获取数据，有一些可能为空
            byte[] arr = packet.getData();
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            // 获取有效的字节个数
            int len = packet.getLength();
            System.out.println(ip + " " + port + " " + new String(arr, 0, len));
        }
    }
}

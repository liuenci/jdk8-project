package com.cier.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo3_MoreThread {


    public static void main(String[] args) throws InterruptedException {
        new Receive().start();
        Thread.sleep(1000);
        new Send().start();
    }
}

class Receive extends Thread {
    @Override
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(6666);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Send extends Thread {
    @Override
    public void run() {
        try {
            // 可以不指定端口号
            DatagramSocket socket = new DatagramSocket();
            // 封装数据包，指定数据，长度，地址，端口
            // 创建键盘录入对象
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if ("quit".equals(line)) {
                    break;
                }
                DatagramPacket packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
                // 发送数据包
                socket.send(packet);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
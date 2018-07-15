package com.cier.socket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo4_GUIChat extends Frame {
    Button send = null;
    Button log = null;
    Button clear = null;
    Button shake = null;
    TextArea viewText = null;
    TextArea sendText = null;
    TextField textField = null;

    public Demo4_GUIChat() {
        init();
        southPanel();
        centerPanel();
        event();
    }

    public void event() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });


    }

    private void send() throws IOException {
        String message = sendText.getText();
        String ip = textField.getText();


        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName(ip), 9999);
        socket.send(packet);

        String time = getCurrentTime();
        viewText.append(time + "我对" + ip + "说\r\n" + message + "\r\n");
        sendText.setText("");
    }

    private String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public void centerPanel() {
        Panel panel = new Panel();
        viewText = new TextArea();
        viewText.setEditable(false);
        viewText.setBackground(Color.white);
        sendText = new TextArea(5, 1);
        panel.setLayout(new BorderLayout());
        panel.add(sendText, BorderLayout.SOUTH);
        panel.add(viewText, BorderLayout.CENTER);
        this.add(panel, BorderLayout.CENTER);
    }

    public void southPanel() {
        Panel south = new Panel();
        textField = new TextField(15);
        textField.setText("127.0.0.1");
        send = new Button("发送");
        log = new Button("记录");
        clear = new Button("清屏");
        shake = new Button("震动");
        south.add(textField);
        south.add(send);
        south.add(log);
        south.add(clear);
        south.add(shake);

        this.add(south, BorderLayout.SOUTH);
    }

    public void init() {
        this.setLocation(500, 50);
        this.setSize(400, 600);
        new Receive().start();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo4_GUIChat();
    }

    private class Receive extends Thread {
        @Override
        public void run() {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(9999);
                DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);

                while (true){
                    datagramSocket.receive(packet);

                    byte[] arr = packet.getData();
                    int len = packet.getLength();
                    String message = new String(arr, 0, len);

                    String time = getCurrentTime();
                    String ip = packet.getAddress().getHostAddress();
                    viewText.append(time + ip + "对我说\r\n" + message + "\r\n");
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

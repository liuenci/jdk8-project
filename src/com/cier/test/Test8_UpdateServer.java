package com.cier.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 3. 建立多线程的服务器
 * 4. 读取文件名
 * 5. 判断文件是否存在，将结果返回给客户端
 * 8. 定义 FileOutputStream,从网络中读取数据，存储到本地
 */
public class Test8_UpdateServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("服务器启动");

        // 创建多线程
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream printStream = new PrintStream(socket.getOutputStream());
                        String line = bufferedReader.readLine();

                        File file = new File("update");
                        // 创建文件夹
                        file.mkdir();
                        // 封装成 file 对象
                        File file1 = new File(file, line);

                        // 如果服务器已经存在这个文件
                        if (file1.exists()) {
                            printStream.println("存在");
                            // 关闭 socket
                            socket.close();
                            return;
                        }

                        printStream.println("不存在");

                        FileOutputStream fileOutputStream = new FileOutputStream(file1);
                        InputStream inputStream = socket.getInputStream();

                        byte[] arr = new byte[8192];
                        int len;

                        while ((len = inputStream.read(arr)) != -1){
                            fileOutputStream.write(arr,0,len);
                        }
                        fileOutputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}

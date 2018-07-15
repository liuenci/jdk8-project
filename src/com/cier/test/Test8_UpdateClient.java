package com.cier.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1. 提示要上传的文件路径，验证路径是否存在不以及是否是文件夹
 * 2. 发送文件名到服务器
 * 6. 接收结果，如果存在给予提示，程序直接退出
 * 7. 如果不存在，定义 FileInputStream 读取文件，写出到网络
 */
public class Test8_UpdateClient {


    public static void main(String[] args) throws IOException {
        File file = getFile();

        Socket socket = new Socket("127.0.0.1",12345);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        printStream.println(file.getName());

        String line = bufferedReader.readLine();
        if ("存在".equals(line)){
            System.out.println("您上传的文件已经存在，请不要重复上传");
            socket.close();
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] arr = new byte[8192];
        int len;
        while ((len = fileInputStream.read(arr)) != -1) {
            printStream.write(arr,0,len);
        }
        fileInputStream.close();
        socket.close();
    }

    private static File getFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件路径:");
        while (true) {
            String line = scanner.nextLine();
            File file = new File(line);
            if (!file.exists()){
                System.out.println("您录入的文件路径不存在，请重新录入:");
            } else if (file.isDirectory()) {
                System.out.println("您录入的是文件夹路径，请输入一个文件路径:");
            } else {
                return file;
            }
        }
    }
}

package com.cier.io;

import java.io.*;

public class Demo6 {

    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("h.txt"));
        int x = dataInputStream.readInt();
        int y = dataInputStream.readInt();
        int z = dataInputStream.readInt();
        System.out.println(x + " " + y + " " + z);
    }

    public static void demo3() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("h.txt"));
        dataOutputStream.writeInt(997);
        dataOutputStream.writeInt(998);
        dataOutputStream.writeInt(999);
        dataOutputStream.close();

    }

    public static void demo2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("h.txt");
        // 读取的时候会在字节前面拼接 24 个0，保证一个整形为 4 个字节。
        int x = fileInputStream.read();
        int y = fileInputStream.read();
        int z = fileInputStream.read();
        System.out.println(x + " " + y + " " + z);
    }

    public static void demo1() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("h.txt");
        // 字节流往文件中写入数据的时候，是一个字节一个字节的写，一个字节是八位，但是一个整形是4位，就是 32 个字节，会截取最后 8 个字节进行写入。
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);
        fileOutputStream.close();
    }
}

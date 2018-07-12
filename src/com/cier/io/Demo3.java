package com.cier.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo3 {

    public static void main(String[] args) throws IOException{
        RandomAccessFile randomAccessFile = new RandomAccessFile("g.txt","rw");
//        randomAccessFile.write(97);
//        int x = randomAccessFile.read();
//        System.out.println(x);;
        // 随机写，而且不会清空里面的东西
        randomAccessFile.seek(0);
        randomAccessFile.write(98);
        randomAccessFile.close();
    }
}

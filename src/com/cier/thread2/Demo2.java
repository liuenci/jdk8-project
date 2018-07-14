package com.cier.thread2;

import java.io.IOException;

public class Demo2 {

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        // runtime.exec("shutdown -s -t 300");
        runtime.exec("shutdown -a");
    }
}

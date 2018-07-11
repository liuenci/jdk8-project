package com.cier.writer;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Demo4 {

    public static void main(String[] args) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("hello.txt"));

        String line;
        // 以 101 开始
        lineNumberReader.setLineNumber(100);
        while ((line = lineNumberReader.readLine()) != null){
            System.out.println(lineNumberReader.getLineNumber() + ":" + line);
        }

        lineNumberReader.close();
    }
}

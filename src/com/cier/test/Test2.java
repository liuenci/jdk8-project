package com.cier.test;

import java.io.*;
import java.util.TreeMap;

public class Test2 {
    /**
     * 获取一个文本上每个字符出现的次数，将结果写到 times.txt 中
     * 1. 创建带缓冲的输入流对象
     * 2. 创建双列集合对象 TreeMap
     * 3. 将读到的字符存储在双列集合中，存储的时候要做判断，如果不包含这个件，就将键和 1 存储
     * 如果包含这个键，就将这个键的值加 1 存储。
     * 4. 关闭输入流
     * 5. 创建输出流对象
     * 6. 遍历集合将集合中的内容写到 times.txt 中。
     * 7. 关闭输出流
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("hello.txt"));
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        int ch;
        while ((ch = bufferedReader.read()) != -1) {
            char c = (char) ch;
            /*if (treeMap.containsKey(c)) {
                treeMap.put(c, treeMap.get(c) + 1);
            } else {
                treeMap.put(c, 1);
            }*/
            treeMap.put(c, treeMap.containsKey(c) ? treeMap.get(c) + 1 : 1);
        }
        bufferedReader.close();

        // 创建输出流对象
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("times.txt"));
        for (Character character : treeMap.keySet()) {
            switch (character) {
                case '\r':
                    bufferedWriter.write("\\r" + "=" + treeMap.get(character));
                    break;
                case '\n':
                    bufferedWriter.write("\\n" + "=" + treeMap.get(character));
                    break;
                case '\t':
                    bufferedWriter.write("\\t" + "=" + treeMap.get(character));
                    break;
                default:
                    bufferedWriter.write(character + "=" + treeMap.get(character));
                    break;
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}

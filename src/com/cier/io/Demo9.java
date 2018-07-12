package com.cier.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Demo9 {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        System.out.println(properties);
        // 加载配置文件
        properties.load(new FileInputStream("config.properties"));
        System.out.println(properties);
        // 在内存中修改，没有在硬盘上修改
        properties.setProperty("tel","12322");
        // 写回硬盘
        properties.store(new FileOutputStream("config.properties"), "列表描述");
        System.out.println(properties);

    }

    public static void demo2() {
        Properties properties = new Properties();
        properties.setProperty("name", "张三");
        properties.setProperty("tel", "1234567890");

//        System.out.println(properties);
        Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
        String key = null;
        while (enumeration.hasMoreElements()){
            key=  enumeration.nextElement();
            System.out.println(key + " " + properties.get(key));
        }
    }

    /**
     * Properties 是 Hashtable 的子类
     */
    public static void demo1() {
        Properties properties = new Properties();
        properties.put("abc", 123);
        System.out.println(properties);
    }

}

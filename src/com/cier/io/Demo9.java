package com.cier.io;

import java.util.Enumeration;
import java.util.Properties;

public class Demo9 {

    public static void main(String[] args) {
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

package com.cier.syl;


import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Demo {
    public static void main(String[] args) {
        try {
            // 使用基本的 Base64 编码
            String base64encodedString = Base64.getEncoder().encodeToString("www.baidu.com".getBytes("utf-8"));
            System.out.println(base64encodedString);
            // 解码并输出结果
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println(new String(base64decodedBytes, "utf-8"));
            // 使用 url 类型的 Base64 编码
            base64encodedString = Base64.getUrlEncoder().encodeToString("www.baidu.com".getBytes("utf-8"));
            System.out.println(base64encodedString);
            // MIME 类型的 Base64 编码
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                stringBuilder.append(UUID.randomUUID().toString());
            }
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println(mimeEncodedString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

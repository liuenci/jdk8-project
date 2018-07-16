package com.cier.threadsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Demo1_Immutable {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a",1);
    }
}

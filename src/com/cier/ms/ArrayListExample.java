package com.cier.ms;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);

        ArrayList list = new ArrayList();
        list.add("ss");
        list.add("sg");

        arrayList.addAll(list);

        arrayList.forEach(System.out::println);
    }
}

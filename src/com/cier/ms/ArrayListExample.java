package com.cier.ms;

import java.util.ArrayList;
import java.util.Iterator;

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

        Object value = null;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            value = iterator.next();
            System.out.println(value);
        }

        arrayList.forEach(System.out::println);
    }
}

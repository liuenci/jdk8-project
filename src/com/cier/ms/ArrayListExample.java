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
        System.out.println("==============");
        for (int i = 0; i < arrayList.size();i++){
            value = arrayList.get(i);
            System.out.println(value);
        }
        System.out.println("==============");
        arrayList.forEach(System.out::println);
        System.out.println("==============");
        for (Object o:arrayList){
            System.out.println(o);
        }
    }
}

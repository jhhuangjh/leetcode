package org.jh.learn;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author hjh
 * @version 1.0
 * @date 2021/4/27 0:04
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(""+ i);
        }
        System.out.println(list.size());

        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 10086; i++) {
            myHashMap.put("key" + i, "value" + i);
        }
        System.out.println("MyHashMap size is " + myHashMap.size());
        System.out.println("MyHashMap threshold is " + myHashMap.threshold);

    }
}

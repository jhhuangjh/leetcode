package org.jh.learn;

import java.util.ArrayList;

/**
 * @author hjh
 * @version 1.0
 * @date 2021/4/27 0:04
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(""+ i);
        }
        System.out.println(list.size());
    }
}

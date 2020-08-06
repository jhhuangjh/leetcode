package org.jh.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author hjh
 * @version 1.0
 * @date 2020/1/17 10:11
 */
public class ValidStr {
    public static void main(String[] args) {
        String s = ")}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>(16);
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (hashMap.containsKey(temp)) {
                char elememt = stack.empty() ? '?' : stack.pop();
                if (elememt != hashMap.get(temp)) {
                    return false;
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.empty();
    }
}

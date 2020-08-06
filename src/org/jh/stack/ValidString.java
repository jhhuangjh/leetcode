package org.jh.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author hjh
 * @version 1.0
 * @date 2020/1/6 17:25
 */
public class ValidString {
    private static HashMap<Character,Character> map = new HashMap<>();
    static {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

    }
    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)){
                char toElement = stack.isEmpty() ? '?' : stack.pop();
                if (toElement != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.empty();

    }

    public static void main(String[] args) {
        String s = "})";
        System.out.println(isValid(s));
    }
}

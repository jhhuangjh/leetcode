package org.jh.str;

/**
 * @author hjh
 * @version 1.0
 * @date 2020/8/2 17:35
 */
public class StringLeetCode {

    /**
     * @param s s = "abcdefg"
     * @param n  n = 2
     * @return "cdefgab"
     */
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

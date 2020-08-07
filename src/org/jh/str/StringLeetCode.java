package org.jh.str;

/**
 * @author hjh
 * @version 1.0
 * @date 2020/8/2 17:35
 */
public class StringLeetCode {

    /**
     * @param s s = "abcdefg"
     * @param n n = 2
     * @return "cdefgab"
     */
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     *
     * @param address address = "1.1.1.1"
     * @return "1[.]1[.]1[.]1"
     */
    public String defangIPaddr(String address) {
        /*String[] strings = address.split("[.]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length - 1) {
                sb.append(strings[i]).append("[.]");
            } else {
                sb.append(strings[i]);
            }
        }
        return sb.toString();*/

        //return address.replace("." , "[.]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') {
                sb.append(address.charAt(i));
            } else {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }


}

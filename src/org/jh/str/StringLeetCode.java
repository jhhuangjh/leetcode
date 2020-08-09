package org.jh.str;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi]
     * 表示该线路将会从 cityAi 直接前往 cityBi 。
     * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
     *
     * @param paths paths = [["B","C"],["D","B"],["C","A"]]
     * @return "A"
     * @date 2020/08/09
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        // 将所有路径的起点与终点存入map
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        for (String key : map.keySet()) {
            // 如果某个路径的终点不是另一个路径的起点，则该点就是旅行终点
            if (map.get(map.get(key)) == null) {
                return map.get(key);
            }
        }
        return "";
    }


}

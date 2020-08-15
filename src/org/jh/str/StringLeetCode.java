package org.jh.str;

import java.util.*;

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

    /**
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * s[i] = 'L' 或 'R'
     * 分割得到的每个字符串都必须是平衡字符串。
     *
     * @param s s = "RLRRLLRLRL"
     * @return 4 "RL", "RRLL", "RL", "RL"
     */
    public int balancedStringSplit(String s) {
       /* Stack<Character> stack = new Stack<Character>();
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
            }
            else{
                stack.pop();
            }
            if(stack.isEmpty()) {
                result++;
            }
        }
        return result;*/
        int num = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                num--;
            } else {
                num++;
            }
            if (num == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
     * "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
     * "..-","...-",".--","-..-","-.--","--.."]
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。
     * 例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。
     * 我们将这样一个连接过程称作单词翻译。
     * 返回我们可以获得所有词不同单词翻译的数量。
     * 各单词翻译如下:
     * "gin" -> "--...-."
     * "zen" -> "--...-."
     * "gig" -> "--...--."
     * "msg" -> "--...--."
     * 共有 2 种不同翻译, "--...-." 和 "--...--.".
     *
     * @param words words = ["gin", "zen", "gig", "msg"]
     * @return 2
     * @date 2020/08/12
     */
    public int uniqueMorseRepresentations(String[] words) {
        // 摩尔斯密码表
        String[] strings = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> resultSet = new HashSet<>();
        // 遍历words，得到每个word的单词翻译
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(strings[word.charAt(i) - 97]);
            }
            resultSet.add(sb.toString());
        }
        return resultSet.size();
    }

    /**
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     *
     * @param moves "UD"
     * @return true
     */
    public boolean judgeCircle(String moves) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    a++;
                    break;
                case 'D':
                    a--;
                    break;
                case 'R':
                    b++;
                    break;
                case 'L':
                    b--;
                    break;
                default:
                    ;
            }
        }
        return a == 0 && b == 0;
    }

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     *
     * @param num1 num1 = "2"
     * @param num2 num2 = "3"
     * @return "6"
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ansArr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = len1 + len2 - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int index = ansArr[0] == 0 ? 1 : 0;
        while (index < len1 + len2) {
            sb.append(ansArr[index++]);
        }
        return sb.toString();
    }


}

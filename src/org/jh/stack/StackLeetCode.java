package org.jh.stack;

import java.util.Stack;

/**
 * @author hjh
 * @version 1.0
 * @date 2020/8/15 14:29
 */
public class StackLeetCode {

    /**
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
     * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），
     * 其中 A 和 B 都是非空有效括号字符串。
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，
     * 使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     * <p>
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     *
     * @param S "(()())(())(()(()))"
     * @return "()()()()(())"
     */
    public String removeOuterParentheses(String S) {
        /*Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (stack.empty()) {
                    sb.append(S.substring(index + 1, i));
                    index = i + 1;
                }
            }
        }
        return sb.toString();*/
        int left = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(' && left++ > 0) {
                result.append('(');
            }
            if (S.charAt(i) == ')' && --left > 0) {
                result.append(')');
            }
        }
        return result.toString();
    }

    /**
     * 剑指 Offer 09. 用两个栈实现队列
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * (若队列中没有元素，deleteHead 操作返回 -1 )
     * @date 2020.08.18
     */
    private class CQueue {
        private Stack<Integer> addStack;
        private Stack<Integer> delStack;
        private int size;

        public CQueue() {
            addStack = new Stack<>();
            delStack = new Stack<>();
            size = 0;
        }

        public void appendTail(int value) {
            addStack.push(value);
            size++;
        }

        public int deleteHead() {
            if (size == 0) return -1;
            if (delStack.empty()) {
                while (!addStack.empty()) {
                    delStack.push(addStack.pop());
                }
            }
            size--;
            return delStack.pop();
        }
    }

}

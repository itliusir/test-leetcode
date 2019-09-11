package com.itliusir.trie;

import java.util.Stack;

/**
 * problem.20
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author liugang
 * @since 2019/8/28
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        String[] left = {"(", "{", "["};
        String[] right = {")", "}", "]"};
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (char aChar : chars) {
            String str = String.valueOf(aChar);
            if (containEle(left, str) != -1) {
                stack.push(str);
            } else {
                int index = containEle(right, str);
                if (!left[index].equals(stack.empty() ? '#' : stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int containEle(String[] arr, String ele) {
        for (int i = 0; i < arr.length; i++) {
            if (ele.equals(String.valueOf(arr[i]))) {
                return i;
            }
        }
        return -1;
    }

}

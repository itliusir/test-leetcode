package com.itliusir.trie;

import java.util.Stack;

/**
 * problem.394
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * @author liugang
 * @since 2019/8/29
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new DecodeString().decodeString(s));
    }

    private String decodeString(String s) {
        int multi = 0;
        StringBuilder result = new StringBuilder();
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '[') {
                multiStack.push(multi);
                charStack.push(result.toString());
                multi = 0;
                result = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curMulti = multiStack.pop();
                for (int i = 0; i < curMulti; i++) {
                    temp.append(result);
                }
                result = new StringBuilder(charStack.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

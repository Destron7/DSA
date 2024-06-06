/*
 * 394. Decode String {STACK}
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits are
 * only for those repeat numbers, k. For example, there will not be input like
 * 3a or 2[4].
 * 
 * The test cases are generated so that the length of the output will never
 * exceed 105.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * 
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * 
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */

import java.util.Stack;

public class LeetCode394 {

}

class Solution {
    public String decodeString(String s) {
        String resultStr = "";
        String appendStr = "";
        char[] inpStr = s.toCharArray();
        Stack<String> stk = new Stack<>();
        int repeat = 1;
        for (int i = 0; i < s.length(); i++) {
            if (inpStr[i] != ']') {
                stk.push(Character.toString(inpStr[i]));
            } else {
                if (stk.isEmpty()) {
                    return "invalid Input";
                }
                while (stk.peek() != "[" && !stk.isEmpty()) {
                    appendStr += stk.pop();
                }
                if (!stk.isEmpty()) {
                    stk.pop(); // REMOVING THE EXTRA "[" BRACKET
                    if (!stk.isEmpty()) {
                        String temp = stk.peek();
                        if (temp.compareTo("9") <= 0 && temp.compareTo("0") >= 0) {
                            repeat = Integer.parseInt(stk.pop());
                        }
                        String tempStr = "";
                        for (int j = 0; j < repeat; j++) {
                            tempStr += appendStr;
                        }
                        stk.push(tempStr);
                    }
                } else {
                    return "invalid Input";
                }
            }
        }
        for (String str : stk) {
            resultStr += str;
        }
        return resultStr;
    }
}
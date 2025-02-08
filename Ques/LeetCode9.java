/*9. Palindrome Number
Easy
Hint: Given an integer x, return true if x is a palindrome, and false otherwise. 
*/
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        return (x == reverseNumber(x));
    }

    public int reverseNumber(int num) {
        int reverse = 0;
        while (num > 0) {
            reverse = (reverse * 10) + (num % 10);
            num /= 10;
        }
        return reverse;
    }
}
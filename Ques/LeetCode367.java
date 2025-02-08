/*367. Valid Perfect Square
Easy
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer. */

public class LeetCode367 {
    public static void main(String[] args) {
        int num = 1;

        Solution sol = new Solution();
        System.out.println(sol.isPerfectSquare(num));
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 0, end = num / 2;
        System.out.println(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
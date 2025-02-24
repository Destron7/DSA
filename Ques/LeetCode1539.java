/*
 * 1539. Kth Missing Positive Number
Easy
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */

import java.util.ArrayList;

public class LeetCode1539 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 2, 3, 4, 7, 11 };
        System.out.println(sol.findKthPositive(arr, 5));
    }
}

class Solution {

    public static void appendArr(ArrayList<Integer> arrList, int from, int to) {
        System.out.println("FROM: " + from + " TO: " + to);
        for (int i = from; i < to; i++) {
            arrList.add(i);
        }
    }

    public int findKthPositive(int[] arr, int k) {
        ArrayList arrList = new ArrayList<Integer>();
        boolean hasNoMissing = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                if (i == 0) {
                    appendArr(arrList, 1, arr[i]);
                } else {
                    appendArr(arrList, arr[i - 1] + 1, arr[i]);
                }
                hasNoMissing = false;
            }
        }

        if (hasNoMissing || arrList.size() < k) {
            appendArr(arrList, arr[arr.length - 1] + 1, arr[arr.length - 1] + 1 + k);
        }
        return (int) arrList.get(k - 1);
    }
}
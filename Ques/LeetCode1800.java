/*
1800. Maximum Ascending Subarray Sum
Easy
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending */

/*Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65. */

public class LeetCode1800 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 10, 20, 30, 5, 10, 50 };
        System.out.println(sol.maxAscendingSum(nums));
    }
}

class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int innerSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    innerSum += nums[j];
                } else
                    break;
            }
            sum = Math.max(sum, innerSum);
        }
        return sum;
    }
}
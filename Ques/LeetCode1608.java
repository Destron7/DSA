package Repo.DSA.Ques;

import java.util.Arrays;

/*
 * 1608. Special Array With X Elements Greater Than or Equal X
    Easy
You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique
*/

public class LeetCode1608 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 0, 4, 3, 0, 4 };
        System.out.println(sol.specialArray(nums));
    }
}

class Solution {

    public static int getEqualOrLargerIndex(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                index = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return index;
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            int indexGreaterThenEqualto = getEqualOrLargerIndex(nums, i);
            if (nums.length - indexGreaterThenEqualto == i) {
                return i;
            }
        }
        return -1;
    }
}
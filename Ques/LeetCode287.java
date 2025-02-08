/*
287. Find the Duplicate Number
Medium

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times. */

import java.util.Arrays;

public class LeetCode287 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] nums = { 3, 3, 3, 3, 3 };
        int nums[] = { 3, 1, 3, 4, 2 };
        System.out.println(sol.findDuplicate(nums));
        System.out.println(Arrays.toString(nums));
    }

}

class Solution {

    public static void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void cyclicSort(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int correct = nums[index] - 1;
            if (nums[index] != nums[correct]) {
                swap(index, correct, nums);
            } else
                index++;
        }
    }

    public int findDuplicate(int[] nums) {
        cyclicSort(nums);

        return nums[nums.length - 1];
    }
}
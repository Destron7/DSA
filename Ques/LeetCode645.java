/*
645. Set Mismatch
Easy
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
 */

import java.util.Arrays;

public class LeetCode645 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 2, 4, 2 };
        System.out.println(Arrays.toString(sol.findErrorNums(nums)));
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

    public int[] findErrorNums(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] { nums[i], i + 1 };
            }
        }
        return new int[] { -1, -1 };
    }
}
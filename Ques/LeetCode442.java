/*
442. Find All Duplicates in an Array
Medium

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode442 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(sol.findDuplicates(nums));
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

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }
        ans.sort((o1, o2) -> o1 - o2);
        return ans;
    }
}
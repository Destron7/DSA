// There is an integer array nums sorted in ascending order(with distinct values).

// Prior to being passed to your function,nums is possibly rotated at an unknown pivot index k(1<=k<nums.length)such that the resulting array is[nums[k],nums[k+1],...,nums[n-1],nums[0],nums[1],...,nums[k-1]](0-indexed).For example,[0,1,2,4,5,6,7]might be rotated at pivot index 3 and become[4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target,return the index of target if it is in nums,or-1 if it is not in nums.

// You must write an algorithm with O(log n)runtime complexity.

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1

import java.util.Arrays;

public class LeetCode33 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] nums = { 3, 4, 5, 6, 7, 1, 2 };
        int[] nums = { 1, 2, 3 };
        System.out.println(Arrays.toString(nums));
        System.out.println(sol.search(nums, 1));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int pivot = getPivotIndex(nums);
        System.out.println("PIVOT: " + pivot);
        if (pivot == -1) {
            start = 0;
            end = nums.length - 1;
        } else if (nums[pivot] == target) {
            return pivot;
        } else if (target >= nums[0] && target <= nums[pivot]) {
            start = 0;
            end = pivot;
        } else {
            start = pivot + 1;
            end = nums.length - 1;
        }
        System.out.println("Start: " + start + " End: " + end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }

    // arr = [3,4,5,6,7,0,1,2]
    // s m e
    //
    public int getPivotIndex(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.err.println("MID: " + mid);
            if ((mid < end) && (nums[mid] > nums[mid + 1]))
                return mid;
            if ((mid > start) && nums[mid] < nums[mid - 1])
                return mid - 1;
            if (nums[mid] < nums[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
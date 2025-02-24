/*
 * 540. Single Element in a Sorted Array
Medium
Topics
Companies
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
*/

public class LeetCode540 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println(sol.singleNonDuplicate(nums));
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
                mid = mid - 1;
            }
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else
                end = mid;
        }
        return nums[end];
    }
}
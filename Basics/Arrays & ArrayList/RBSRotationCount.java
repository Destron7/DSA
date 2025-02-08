/*
 * Rotation Count in a Rotated Sorted array
 * 
 * Given an array arr[] having distinct numbers sorted in increasing order and the array has been right rotated (i.e, the last element will be cyclically shifted to the starting position of the array) k number of times, the task is to find the value of k.
 * 
 * Input: arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation: Initial array must be {2, 3, 6, 12, 15, 18}. 
We get the given array after rotating the initial array twice.


Input: arr[] = {7, 9, 11, 12, 5}
Output: 4


Input: arr[] = {7, 9, 11, 12, 15};
Output: 0
 */

public class RBSRotationCount {
    public static void main(String[] args) {
        // int[] nums = { 3, 4, 5, 6, 7, 1, 2 };
        // int[] nums = { 1, 2, 3 };
        int[] nums = {2, 3, 6, 12};
        System.out.println(getPivotIndex(nums) + 1);
    }

    public static int getPivotIndex(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid > start) && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if ((mid < end) && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}

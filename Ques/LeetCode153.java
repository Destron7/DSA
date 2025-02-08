public class LeetCode153 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 3, 4, 5, 6, 7, 1, 2 };
        System.out.println(sol.findMin(nums));
    }
}

class Solution {
    public int findMin(int[] nums) {
        return nums[(getPivot(nums) + 1) % nums.length];
    }

    public int getPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid > start) && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if ((end > mid) && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[start])
                end = mid - 1;
            else
                start = start + 1;
        }
        return -1;
    }
}
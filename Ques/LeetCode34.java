import java.util.Arrays;

public class LeetCode34 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(new int[] { 1, 2, 2, 3, 7, 7, 7, 7, 8, 10 }, 8)));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = search(nums, target, false);
        return new int[] { first, last };
    }

    public static int search(int[] arr, int target, boolean searchingFirst) {
        int ans = -1;
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid])
                end = mid - 1;
            else if (target > arr[mid])
                start = mid + 1;
            else {
                ans = mid;
                if (searchingFirst)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }
}
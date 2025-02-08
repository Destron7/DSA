import java.util.Arrays;

public class LeetCode852 {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 1, 0 };
        Solution sol = new Solution();
        System.out.println(sol.peakIndexInMountainArray(arr));
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1])
                start = mid + 1;
            else if (arr[mid] > arr[mid + 1])
                end = mid;
        }
        return start;
    }
}
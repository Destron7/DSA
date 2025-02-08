// You may recall that an array arr is a mountain array if and only if:

// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

// You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// MountainArray.length() returns the length of the array.
// Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

public class LeetCode1095 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findInMountainArray(2, new int[] { 0, 1, 2, 4, 2, 1 }));
    }
}

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, int[] arr) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1])
                end = mid;
            else if (arr[mid] < arr[mid + 1])
                start = mid + 1;
        }
        ans = findElement(target, arr, 0, end, true);
        if (ans == -1) {
            ans = findElement(target, arr, end, arr.length - 1, false);
        }
        return ans;
    }

    public int findElement(int target, int[] arr, int s, int e, boolean isAscending) {
        int start = s, end = e;
        if (isAscending) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > target)
                    end = mid - 1;
                else if (arr[mid] < target)
                    start = mid + 1;
                else
                    return mid;
            }
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > target)
                    start = mid + 1;
                else if (arr[mid] < target)
                    end = mid - 1;
                else
                    return mid;
            }
        }
        return -1;
    }
}
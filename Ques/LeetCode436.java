/*436. Find Right Interval
Medium
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 

Constraints:

1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-106 <= starti <= endi <= 106
The start point of each interval is unique */

import java.util.Arrays;

public class LeetCode436 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[][] intervals = { { 1, 2 } };
        int[][] intervals = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
        System.out.println(Arrays.toString(sol.findRightInterval(intervals)));
    }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] indexedIntervals = new int[n][3]; // Stores [start, end, original_index]

        // Step 1: Store the intervals along with their original index
        for (int i = 0; i < n; i++) {
            indexedIntervals[i][0] = intervals[i][0]; // start
            indexedIntervals[i][1] = intervals[i][1]; // end
            indexedIntervals[i][2] = i; // original index
        }

        // Step 2: Sort intervals by start value
        Arrays.sort(indexedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];

        // Step 3: Find the right interval using binary search
        for (int i = 0; i < n; i++) {
            int target = indexedIntervals[i][1]; // end of current interval
            int idx = binarySearch(indexedIntervals, target);
            result[indexedIntervals[i][2]] = (idx == -1) ? -1 : indexedIntervals[idx][2];
        }

        return result;
    }

    // Binary Search: Find the first interval whose start is >= target
    private int binarySearch(int[][] intervals, int target) {
        int left = 0, right = intervals.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (left < intervals.length) ? left : -1;
    }
}
/*167. Two Sum II - Input Array Is Sorted
Medium
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space. */

public class LeetCode167 {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 20;

        Solution sol = new Solution();
        int[] result = sol.twoSum(numbers, target);

        System.out.println(result[0] + " " + result[1]);
    }

}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length - 1;

        while (first < last) {
            int sum = numbers[first] + numbers[last];

            if (sum == target) {
                return new int[] { first + 1, last + 1 };
            } else if (sum < target) {
                first++;
            } else {
                last--;
            }
        }

        return new int[] { -1, -1 };
    }
}
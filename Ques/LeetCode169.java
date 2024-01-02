// package Ques;

import java.util.*;

public class LeetCode169 {
    public static void main(String[] args) {
        int[] nums = { 6, 3, 6 };
        System.out.println(Solution2.majorityElement(nums));
    }
}
// solution2 1 
class Solution2 {
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }
}

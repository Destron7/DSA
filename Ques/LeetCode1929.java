
// 
/*
 * Q1929> (Easy)
 * Given an integer array nums of length n, you want to create an array ans of
 * length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n
 * (0-indexed).
 * 
 * Specifically, ans is the concatenation of two nums arrays.
 * 
 * Return the array ans.
 */

import java.util.Scanner;

public class LeetCode1929 {
}

class Solution4 {

    public static int ans[];
    public static int nums[];

    public int[] getConcatenation(int[] nums) {
        ans = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[nums.length + i] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution4 obj = new Solution4();
        int[] nums = { 1, 2, 1 };
        System.out.println(nums);
        ans = obj.getConcatenation(nums);
        System.out.print("SOLUTION4 ARRAY: [");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(" " + ans[i] + " ");
        }
        System.out.println("]");
    }
}

class DynamicSolution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution4 obj = new Solution4();
        System.out.print("ENTER SIZE OF ARRAY NUMS: ");
        int n = sc.nextInt();
        for (int i = 0; i < obj.nums.length; i++) {
            System.out.print("ENTER ELEMENT " + (i + 1) + ": ");
            obj.nums[i] = sc.nextInt();
        }
        System.out.println(obj.nums);
        obj.ans = obj.getConcatenation(obj.nums);
        System.out.print("SOLUTION4 ARRAY: [");
        for (int i = 0; i < obj.ans.length; i++) {
            System.out.print(" " + obj.ans[i] + " ");
        }
        System.out.println("]");
    }
}
public class LeetCode1295 {

}

class Solution {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] *= -1;
            if (getLength(nums[i]) % 2 == 0)
                count++;
        }
        return count;
    }

    public static int getLength(int number) {
        // return Integer.toString(number).length();
        return (int) (Math.log10(number)) + 1;
    }

}

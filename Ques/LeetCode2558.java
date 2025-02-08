import java.util.Arrays;
// You are given an integer array gifts denoting the number of gifts in various piles.Every second,you do the following:

// Choose the pile with the maximum number of gifts.If there is more than one pile with the maximum number of gifts,choose any.Leave behind the floor of the square root of the number of gifts in the pile.Take the rest of the gifts.Return the number of gifts remaining after k seconds.

// Example 1:

// Input:gifts=[25,64,9,4,100],k=4 Output:29 Explanation:The gifts are taken in the following way:-In the first second,the last pile is chosen and 10 gifts are left behind.-Then the second pile is chosen and 8 gifts are left behind.-After that the first pile is chosen and 5 gifts are left behind.-Finally,the last pile is chosen again and 3 gifts are left behind.The final remaining gifts are[5,8,9,4,3],so the total number of gifts remaining is 29. Example 2:

// Input:gifts=[1,1,1,1],k=4 Output:4 Explanation:In this case,regardless which pile you choose,you have to leave behind 1 gift in each pile.That is,you can'ttake any pile with you.So,the total gifts remaining are 4.

public class LeetCode2558 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pickGifts(new int[] { 1, 1, 1, 1 }, 4));
    }
}

class Solution {
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        Arrays.sort(gifts);
        for (int i = 1; i <= gifts.length; i++) {
            if (i <= k) {
                gifts[gifts.length - i] = (int) Math.floor(Math.sqrt(gifts[gifts.length - i]));
                sum += (long) gifts[gifts.length - i];
            } else {
                sum += gifts[gifts.length - i];
            }
        }
        return sum;
    }
}
import java.util.Arrays;

public class LeetCode1672 {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 1, 2, 3 }, { 5, 10 } };
        System.out.println(maximumWealth(arr));
    }

    public static int maximumWealth(int[][] accounts) {
        int maxSum = rowSum(accounts[0]);
        for (int i = 1; i < accounts.length; i++) {
            if (rowSum(accounts[i]) > maxSum) {
                maxSum = rowSum(accounts[i]);
            }
        }
        return maxSum;
    }

    public static int rowSum(int[] row) {
        return Arrays.stream(row).sum();
    }
}

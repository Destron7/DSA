import java.math.BigInteger;

public class LeetCode66 {
    public static void main(String[] args) {
        int[] digits = { 9 };
        int[] soln = Solution.plusOne(digits);
        for (int i = 0; i < soln.length; i++) {
            System.out.println(soln[i]);
        }
    }
}

class Solution {
    public static int[] plusOne(int[] digits) {

        StringBuilder str = new StringBuilder();

        for (int digit : digits) {
            str.append(digit);
        }

        BigInteger num = new BigInteger(str.toString());
        num = num.add(BigInteger.ONE);

        String resultStr = num.toString();

        int[] result = new int[resultStr.length()];

        for (int i = 0; i < resultStr.length(); i++) {
            result[i] = Character.getNumericValue(resultStr.charAt(i));
        }
        return result;
    }
}
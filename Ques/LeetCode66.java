public class LeetCode66 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] digits = {1,2,4};
        int [] soln = s.plusOne(digits);
        for (int i = 0; i < soln.length; i++) {
            System.out.println(soln[i]);
        }
    }
}
class Solution {
    public int[] plusOne(int[] digits) {
        if((digits[digits.length-1]+=1)==9){
            if(digits.length>1){
                digits[digits.length-2] += 1;
                digits[digits.length-1] += 0;
            }else{
                int soln[] = new int[digits.length];
                soln[0]=1;
                soln[1]=0;
                return soln;
            }
        }else{
            
        }
        return digits;
    }
}
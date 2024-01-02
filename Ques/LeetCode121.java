
public class LeetCode121 {
    public static void main(String[] args) {
        int prices[] ={7,6,4,3,1};
        System.out.println(Solution3.maxProfit(prices));
    }
}

class Solution3 {
    public static int maxProfit(int[] prices) {
        int good_trans=0;

        for(int i = 0 ; i<prices.length; i++){
            for (int j =i+1 ; j<prices.length; j++){
                if(prices[j]-prices[i]>=0 && prices[j]-prices[i]>=good_trans){
                    good_trans=prices[j]-prices[i];
                }
            }
        }
        return good_trans;
    }
}

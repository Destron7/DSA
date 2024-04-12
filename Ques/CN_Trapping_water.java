
 class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        if (n <= 2) {
            return 0;
        }

        long[] leftMax = new long[n];
        long[] rightMax = new long[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        long totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        long[] elevationMap = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = elevationMap.length;
        long trappedWater = getTrappedWater(elevationMap, n);
        System.out.println("Total amount of trapped rainwater: " + trappedWater);
    }
}


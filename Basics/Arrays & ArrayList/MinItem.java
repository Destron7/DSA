public class MinItem {
    public static void main(String[] args) {
        int[] arr = { 100, -11, -9, 21, 0, 1100 };
        System.out.println(minItem(arr));
    }

    public static int minItem(int[] arr) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (arr[start] < min) {
                min = arr[start];
            } else if (arr[end] < min) {
                min = arr[end];
            }
            start++;
            end--;
        }
        return min;
    }
}

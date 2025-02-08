import java.util.Arrays;

public class SelectionSort {

    public static int getMaximumIndex(int[] arr, int start, int end) {
        int maxI = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[maxI] <= arr[i]) {
                maxI = i;
            }
        }
        return maxI;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maximumIndex = getMaximumIndex(arr, 1, last);
            swap(arr, last, maximumIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 5, 3 };
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
}

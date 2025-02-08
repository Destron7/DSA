import java.util.Arrays;

public class CycleSort {

    public static void cyclicSort(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (arr[index] - 1 == index) {
                index++;
            } else {
                swap(index, arr[index] - 1, arr);
            }
        }
    }

    public static void swap(int from, int to, int[] arr) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 1, 4 };
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

import java.util.Arrays;

/*
 * Insertion sort works by sorting the whole array from left hand side.
 * 
 * WHY USE INSERTION SORT:
 * 1. It is Stable Sroting Algorithm.
 * 2. It is adaptive which complies that the steps in sorting keeps reducing in comparison to bubble sort.
 * 3. Works best for small length of arrays & when array is partially sorted.
 */

public class InsertionSort {

    public static void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(j, j - 1, arr);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1, 4 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

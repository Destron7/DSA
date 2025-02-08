import java.util.Arrays;

public class BubbleSort {

    public static void swap(int x, int y, int[] array) {
        array[x] = array[x] + array[y];
        array[y] = array[x] - array[y];
        array[x] = array[x] - array[y];
    }

    public static void bubbleSort(int[] array) {
        boolean swapped = false;
        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 1; j <= array.length - i - 1; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j, array);
                    swapped = true;
                }
            }
            if (!swapped) {
                System.out.println("ALREADY SORTED!! " + i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // int[] array = { 5, 2, 3, 1, 4 };
            // int[] array = { 5, 4, 3, 2, 1 };
            // int[] array = { 1, 2, 3, 4, 5 };
            int[] array = {};
            if (array.length == 0) {
                throw new Exception("LENGTH OF ARRAY IS ZERO!!!");
            }
            bubbleSort(array);
            System.out.println(Arrays.toString(array));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

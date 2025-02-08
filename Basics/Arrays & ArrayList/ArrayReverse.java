public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        arrayReverse(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void arrayReverseInt(int[] arr) {
        int limit = (int) Math.floor((arr.length / 2));
        if (limit % 2 != 0)
            limit--;
        for (int i = 0; i <= limit; i++)
            swap(arr, i, arr.length - (i + 1));
    }

    public static void arrayReverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        System.out.println("swapping " + index1 + " " + index2);
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

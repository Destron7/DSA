import java.util.Arrays;

public class BinarySearchQuestions {
    public static void main(String[] args) {
        int[] arr = { 4, 9, 10, 11, 13, 14, 17, 20, 24, 27 };
        int target = 15;
        System.out.println(Arrays.toString(Ceil.findCeil(arr, target)));
    }

}

class Ceil {
    public static int[] findCeil(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (target > arr[end])
            return new int[] { -1, -1 };
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("S: " + start + " E: " + end + " M: " + mid);
            if (arr[mid] == target)
                return new int[] { arr[mid], mid };
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[] { arr[start], start };
    }
}

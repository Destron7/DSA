public class AgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = { -10, -5, -3, 0, 2, 4, 7, 9, 12 }; // Already sorted array with negative and positive integers
        int target = 12;
        System.out.println(binarySearchInd(arr, target));
        int[] arrd = { 12, 9, 7, 4, 2, 0, -3, -5, -10 }; // Already sorted array in descending order with negative and
        // positive integers
        target = 12;
        System.out.println(binarySearchInd(arrd, target));
    }

    public static int binarySearchInd(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        Boolean isAsc = arr[0] < arr[arr.length - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;

            if (isAsc) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else if (arr[mid] < target) {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else if (arr[mid] > target) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

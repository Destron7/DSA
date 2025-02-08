import java.util.Arrays;

public class RotataedBinarySearch {
    public static void main(String[] args) {
        // int[] nums = { 3, 4, 5, 6, 7, 1, 2 };
        // int[] nums = { 1, 2, 3 };
        // int[] nums = { 2, 9, 2, 2, 2 };
        int[] nums = { 1 };
        System.out.println(Arrays.toString(nums));
        System.out.println(search(nums, 1));
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int pivot = getPivotIndex(nums);
        // int pivot = getPivotWithDuplicatesIndex(nums);
        System.out.println("PIVOT: " + pivot);
        if (pivot == -1) {
            start = 0;
            end = nums.length - 1;
        } else if (nums[pivot] == target) {
            return pivot;
        } else if (target >= nums[0] && target <= nums[pivot]) {
            start = 0;
            end = pivot;
        } else {
            start = pivot + 1;
            end = nums.length - 1;
        }
        System.out.println("Start: " + start + " End: " + end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int getPivotIndex(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.err.println("MID: " + mid);
            if ((mid < end) && (nums[mid] > nums[mid + 1]))
                return mid;
            if ((mid > start) && nums[mid] < nums[mid - 1])
                return mid - 1;
            if (nums[mid] < nums[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    // arr = [3,4,5,6,7,0,1,2]
    // s m e
    //
    public static int getPivotWithDuplicatesIndex(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid < end) && (nums[mid] >= nums[mid + 1])) {
                return mid;
            }
            if ((mid > start) && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

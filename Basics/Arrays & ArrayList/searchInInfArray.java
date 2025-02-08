// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

import java.util.Arrays;
import java.util.Scanner;

public class searchInInfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(result(arr, 9374));
        sc.close();
    }   
    
    public static int result (int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (arr[end] < target) {
            System.out.println(Arrays.toString(new int[] {start, end}));
            int boxSize = end - start + 1;
            start = end + 1;
            end += boxSize * 2; 
        }

        int ans = search(arr, target, start, end);
        return ans;
    }

    public static int search(int[] arr, int target, int start, int end){
        int s = start;
        int e = end;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if(target > arr[mid]) s = mid + 1;
            else if(target < arr[mid]) e = mid - 1;
            else return mid; 
        }

        return -1;
    }
}

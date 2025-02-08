import java.util.Scanner;

public class MaxItem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(max(arr));

        sc.close();
    }

    public static int max(int[] arr) {
        int m = 0;
        for (int x : arr) {
            if (x >= m) {
                m = x;
            }
        }
        return m;
    }
}

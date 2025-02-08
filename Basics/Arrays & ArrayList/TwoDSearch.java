import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Random;

public class TwoDSearch {
    public static void main(String[] args) {
        Random rand = new Random();
        int rows = rand.nextInt(7) + 1; // Random number of rows between 1 and 7
        int[][] arr = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int cols = rand.nextInt(7) + 1; // Random number of columns between 1 and 7
            arr[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                arr[i][j] = rand.nextInt(100) - 10; // Random integers between -10 and 10
            }
        }

        // Print the array for verification
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int target = 50;
        System.out.println(Arrays.toString(search2D(arr, target)));
    }

    public static int[] search2D(int[][] arr, int target) {
        for (int rows = 0; rows < arr.length; rows++) {
            for (int cols = 0; cols < arr[rows].length; cols++) {
                if (arr[rows][cols] == target) {
                    return new int[] { rows, cols };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}

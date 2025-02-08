import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1 {
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        // for (int i = 0; i <= 5; i++) {
        // arr.add(sc.nextInt());
        // }

        for (int rows = 0; rows < 3; rows++) {
            arr.add(new ArrayList<Integer>());
            for (int col = 0; col < 3; col++) {
                arr.get(rows).add(sc.nextInt());
            }
        }

        System.out.println(arr);

        sc.close();
    }
}

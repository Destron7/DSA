package DSA.Algorithms;

import java.util.*;

public class HanoiTower {
    static void towerHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("MOVE DISK 1 FROM " + from_rod + " TO ROD " + to_rod);
            return;
        }
        towerHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("MOVE DISK " + n + " FROM ROD " + from_rod + " TO ROD " + to_rod);
        towerHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER NO. OF DISCS: ");
        int n = sc.nextInt();
        towerHanoi(n, 'A', 'C', 'B');
    }
}

import java.util.Arrays;

public class BinSearchIn2dSortedArray {
    public static void main(String[] args) {
        // int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 16, 26, 36, 46 }
        // };
        // System.out.println(Arrays.toString(binary2dRowColSortedSearch(matrix, 36)));

        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println(Arrays.toString(binarySearchInSortedMatrix(matrix, 1)));

    }

    static int[] binarySearch(int[][] matrix, int row, int startC, int endC, int target) {
        while (startC <= endC) {
            int middleCol = startC + (endC - startC) / 2;
            if (matrix[row][middleCol] == target) {
                return new int[] { row, middleCol };
            } else if (matrix[row][middleCol] < target) {
                startC = middleCol + 1;
            } else
                endC = middleCol - 1;
        }

        return new int[] { -1, -1 };
    }

    static int[] binarySearchInSortedMatrix(int[][] matrix, int target) {
        try {
            if (matrix[0].length == 0) {
                throw new Exception("THE COLUMN ZERO IS EMPTY!!");
            } else {
                int rows = matrix.length - 1;
                int cols = matrix[0].length - 1;
                int cMid = cols / 2;

                int rStart = 0, rEnd = rows;
                while (rStart < (rEnd - 1)) {
                    int rMid = rStart + (rEnd - rStart) / 2;
                    System.out.println("ROW MIDDLE: " + rMid + "ELEMENT: " + matrix[rMid][cMid]);
                    if (matrix[rMid][cMid] == target) {
                        return new int[] { rMid, cMid };
                    }
                    if (matrix[rMid][cMid] > target) {
                        rEnd = rMid;
                    } else {
                        rStart = rMid;
                    }
                }

                System.out.println("RSTART: " + rStart + " REND: " + rEnd + " CMID: " + cMid);

                for (int i = rStart; i <= rEnd; i++) {
                    System.out.println("matrix[" + i + "][" + cMid + "] --> " + matrix[i][cMid]);
                    if (matrix[i][cMid] == target) {
                        return new int[] { i, cMid };
                    }
                }

                if (matrix[rStart][cMid] < target) {
                    return binarySearch(matrix, rStart, cMid + 1, cols, target);
                }
                if (matrix[rStart][cMid] > target) {
                    return binarySearch(matrix, rStart, 0, cMid - 1, target);
                }
                if (matrix[rEnd][cMid] < target) {
                    return binarySearch(matrix, rEnd, 0, cMid - 1, target);
                } else
                    return binarySearch(matrix, rEnd, cMid + 1, cols, target);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new int[] { -1, -1 };
    }

    static int[] binary2dRowColSortedSearch(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return new int[] { row, col };
            }
            if (target > matrix[row][col]) {
                row++;
            } else
                col--;
        }

        return new int[] { -1, -1 };
    }
}

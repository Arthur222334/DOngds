package OneD;

import java.util.Arrays;

public class Tree {
    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30}, {15, 25, 35, 45}, {28, 29, 37, 49}, {33, 34, 38, 50}
        };
        int target = 37;
        int[] ans = TwoD(mat, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] TwoD(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}

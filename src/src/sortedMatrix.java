package src;

import sun.util.resources.cldr.ext.CurrencyNames_pcm;

public class sortedMatrix {
    //convert into 1D array and apply binary Search
    public static void main(String[] args) {

    }

    //search in the row between the cols provide
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart < cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1) {
            return binarySearch(matrix, 0, 0, col - 1, target);
        }
        int rowStart = 0;
        int rowEnd = row - 1;
        int cMid = col / 2;
        while (rowStart < (rowEnd - 1)) {
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }
            if (matrix[mid][cMid] < target) {
                rowStart = mid;
            } else {
                rowEnd = mid;
            }
        }
        if (matrix[rowStart][cMid] == target) {
            return new int[]{rowStart + 1, cMid}
        }
        if (target <= matrix[cMid - 1][rowStart]) {
            binarySearch(matrix, rowStart, 0, cMid - 1, target)
        }
        if (target >= matrix[cMid + 1][rowStart] && target <= matrix[rowStart][col - 1]) {
            binarySearch(matrix, rowStart, cMid + 1, col - 1, target)
        }
        if (target <= matrix[rowStart + 1][cMid - 1]) {
            return binarySearch(matrix, rowStart + 1, 0, cMid - 1, target)
        } else {
            return binarySearch(matrix, rowStart + 1, cMid+1, cMid - 1, target)
        }
        //run the loop till 2 rows are remaining
        return new int[]{-1, -1};
    }
}

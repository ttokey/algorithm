package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMatrix3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> listMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                listMatrix.add(matrix[i][j]);
            }
        }
        if (Arrays.binarySearch(listMatrix.toArray(), target) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}

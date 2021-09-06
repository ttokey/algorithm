package leetcode.easy;

import org.junit.jupiter.api.Test;

class SearchMatrixTest {
    SearchMatrix searchMatrix = new SearchMatrix();

    @Test
    public void test() {
//        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        int target = 3;
        int[][] matrix = new int[][]{{1}};
        int target = 2;
//        int[][] matrix = new int[][]{{1, 3}};
//        int target = 3;


        boolean result = searchMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

}
package leetcode.easy;

//74. Search a 2D Matrix
/*
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int targetLow = getTargetLow(matrix, target);
        return getTargetCol(matrix[targetLow], target);
    }

    public int getTargetLow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean getTargetCol(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                right = mid - 1;

            } else if (matrix[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}



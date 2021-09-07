package leetcode.easy;

public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int col = matrix[0].length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / col][mid % col];
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

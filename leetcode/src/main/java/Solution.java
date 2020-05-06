/**
 *  编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 */
class Solution {
    private static int[] getArr(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return null;
        int left = 0;
        int right = matrix.length - 1;
        if (matrix.length == 1) {
            if (matrix[0].length == 0) {
                return null;
            }
            if (target >= matrix[0][0] && target <= matrix[0][matrix[0].length - 1]) {
                return matrix[0];
            }
        }
        int mid = (left + right) / 2;
        int len = matrix[mid].length - 1;
        if (target >= matrix[mid][0] && target <= matrix[mid][len]) {
            return matrix[mid];
        }
        while (left < right && (target < matrix[mid][0] || target > matrix[mid][len])) {
            if (target < matrix[mid][0]) {
                right = mid - 1;
            }
            if (target > matrix[mid][len]) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
            len = matrix[mid].length - 1;
            if (target >= matrix[mid][0] && target <= matrix[mid][len]) {
                return matrix[mid];
            }
        }
        return null;
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = getArr(matrix, target);
        if (arr == null) return false;
        if (arr.length != 0 && target <= arr[arr.length - 1] && target >= arr[0]) {
            int left = 0;
            int right = arr.length - 1;
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            }
            while (left < right && arr[mid] != target) {
                if (target < arr[mid]) {
                    right = mid - 1;
                }
                if (target > arr[mid]) {
                    left = mid + 1;
                }
                mid = (left + right) / 2;
                if (arr[mid] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7}, {10,11,16,20},{23,30,34,50}};
        int[][] matrix = {{1},{3}};
        int target = 1;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }
}
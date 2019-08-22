package com.itliusir.array;


/**
 * problem.59
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author liugang
 * @since 2019/8/22
 */
public class HelixMatrixTwo {

    public static void main(String[] args) {
        int n = 4;
        int[][] result = new HelixMatrixTwo().generateMatrix(n);

        printf(result, n);
    }

    public int[][] generateMatrix(int n) {
        int end = 1;
        // 定义从上到下 从左到右边界
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = n * n;
        int[][] result = new int[n][n];
        while (num >= end) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num--;
            }
            // 最上面一行已填充完
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num--;
            }
            //最右边一列已填充完
            right--;
            for (int i = right; i >= left; i--) {
                result[bottom][i] = num--;
            }
            // 最下面一行已填充完
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result[i][left] = num--;
            }
            // 最左边一列已填充完
            left++;
        }
        return result;
    }

    private static void printf(int[][] result, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

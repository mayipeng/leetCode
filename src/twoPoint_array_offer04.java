/*
剑指 Offer 04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:
现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

限制：
0 <= n <= 1000
0 <= m <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class twoPoint_array_offer04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
    }
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while (row<m && col>=0){
            if (matrix[row][col]>target){
                col--;
            }else if (matrix[row][col]<target){
                row++;
            }else if(matrix[row][col]==target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean result = findNumberIn2DArray2(matrix, 18);
        System.out.println("result: "+result);
        // write your code here
    }
}
/*
python:
class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if matrix==[]:
            return False
        else:
            i=0
            j=len(matrix[0])-1
            while i < len(matrix) and j >= 0:
                if matrix[i][j] != target:
                    if matrix[i][j] > target:
                        j -= 1
                    else:
                        i += 1
                else:
                    return True
                    break
            else:
                return False
 */
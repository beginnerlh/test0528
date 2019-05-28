/*
给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。

下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素
在下一行选择的元素和当前行所选元素最多相隔一列。

示例：

输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：12
解释：
可能的下降路径有：
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
和最小的下降路径是 [1,4,7]，所以答案是 12。
*/
package lianxi0528;

public class Test0528 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(s.minFallingPathSum(nums));
    }
}

class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] nums = new int[m][n];
        for(int j=0;j<n;j++){
            nums[0][j] = A[0][j];
        }
        for(int i =1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j == 0){
                    nums[i][j] = Math.min(nums[i-1][j],nums[i-1][j+1])+A[i][j];
                }else if(j == n-1){
                    nums[i][j] = Math.min(nums[i-1][j-1],nums[i-1][j])+A[i][j];

                }else{
                    nums[i][j] = Math.min(Math.min(nums[i-1][j-1],nums[i-1][j]),nums[i-1][j+1]) + A[i][j];

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(min > nums[m-1][i]){
                min = nums[m-1][i];
            }
        }
        return min;
    }
}

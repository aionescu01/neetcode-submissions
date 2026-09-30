class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix[0].length*matrix.length - 1;
        int l = 0;
        while(l<=r){
            int k = l + (r-l) / 2;
            int i = k/matrix[0].length;
            int j = k%matrix[0].length;
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]<target){
                l = k+1;
            }else{
                r=k-1;
            }
        }
        return false;
    }
}

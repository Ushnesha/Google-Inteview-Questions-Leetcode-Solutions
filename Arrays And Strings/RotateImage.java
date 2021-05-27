class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l = 0, r = n-1;
        while(l < r){
            for(int j = l; j < r; j++){
                int tmp = matrix[l][j];
                matrix[l][j] = matrix[n-j-1][l];
                matrix[n-j-1][l] = matrix[n-l-1][n-j-1];
                matrix[n-l-1][n-j-1] = matrix[j][n-l-1];
                matrix[j][n-l-1] = tmp;
            }
            l++;
            r--;
        }
    }
}
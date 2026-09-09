class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows*cols - 1;

        while(left <= right){
            int mid = (left + right)/2;
            int cell = matrix[mid/cols][mid%cols]; 
            if(cell == target){
                return true;
            }else if(cell > target){
                right = mid-1;
            }else if(cell < target){
                left = mid+1;
            }else{
                return false;
            }
        }
        return false;
    }
}
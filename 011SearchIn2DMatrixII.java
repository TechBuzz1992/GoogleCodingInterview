package Day_0105;

class SearchIn2DMatrixII{
    public static boolean searchInMatrix(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols-1;
        while(i<rows && j<cols){
            if(matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target){
                j--;
            } else{
                 i++;
            }
        }
        return false;
    }
}
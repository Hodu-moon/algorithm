class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] matrix = new int[n + 1][m + 1];
        
        
        for(int i = 0; i < puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            matrix[y][x] = -1;
        }
        
        matrix[1][1] = 1;
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1 ; j++){
                
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                    continue;
                }
                
                matrix[i][j] =  (matrix[i][j] + matrix[i - 1][j]) % 1000000007;
                matrix[i][j] = ( matrix[i][j] + matrix[i][j-1]) % 1000000007;
                
            }
        }
        
        
        
        
        return matrix[n][m];
    }
}
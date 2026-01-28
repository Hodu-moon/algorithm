class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown / 2) - 2;
        
        for(int n = 1; n <= sum; n++){
            int m = sum - n;
            
            
            if(n * m == yellow){
                answer[0] = Math.max(n, m) + 2;
                answer[1] = Math.min(n, m) + 2;
            }
            
        }
        
        
        
        
        return answer;
    }
}
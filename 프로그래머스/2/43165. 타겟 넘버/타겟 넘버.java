class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        // dfs 가 생각나네요 
        solve(0, numbers, 0, target);
        
        
        return answer;
    }
    
    static void solve(int depth, int[] numbers, int sum, int target){
        if(depth == numbers.length){
            
            if(sum == target){
                answer++;
            }
            
            return;
        }
        
      
        solve(depth + 1, numbers, sum + numbers[depth], target);
        solve(depth + 1, numbers, sum - numbers[depth], target);
        
        
    }
}
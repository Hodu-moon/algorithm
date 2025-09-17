import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] expire = new int[24 + k + 1];
        
        int current = 0;
        
        
        for(int i = 0; i < players.length; i++){
            // 1. 서버 제거
            current -= expire[i];
            
            // 2. 필요한 증강 수 
            int req = players[i] / m;
            
            int need = req - current  ;
            
            if( need >= 1){
                answer += need;
                current += need;
                expire[i + k] = need;
            }
        
        }
        
        
        return answer;
    }
    
    
}
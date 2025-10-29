import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int n = scores[0][0];
        int m = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return (o1[0] - o2[0]) * -1;
        });
        
        
        int max = scores[0][1];
        
        for(int i = 1; i < scores.length; i++){
            
            if(scores[i][1] < max ){
                
                if(scores[i][0] == n && scores[i][1] == m){
                    return -1;
                }
                
                scores[i][0] = -1;
                scores[i][1] = -1;
                
                
            }else{ // scores[i][1] >= max
                max = scores[i][1];                
            }
        }
        
        Arrays.sort(scores, (o1, o2) -> 
                    {return ((o1[0] + o1[1]) - (o2[0] + o2[1]) )* -1 ;} 
                   
                   );
        
        
        answer = 1;
        for(int[] score : scores){
            if(score[0] + score[1] > n + m ){
                answer++;
            }else{
                break;
            }
            
            
        }
        
        return answer;
    }
    
  
}
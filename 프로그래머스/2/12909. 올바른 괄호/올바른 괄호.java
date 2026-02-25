import java.util.*;

class Solution {
    boolean solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(answer < 0)
                return false;
            
            if(c == '('){
                answer++;
            }else{
                answer--;
            }
            
            
        }
        

        return answer == 0;
    }
}
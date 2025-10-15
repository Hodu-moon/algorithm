import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            
            int num = storey % 10;
            
            if( num  < 5){
                answer += num;
            }else if (num > 5){
                answer += (10 - num);
                storey += (10 - num);
            }else{ // num == 5
                int next = ( storey / 10 ) % 10;
                // 5를 올리거나 내리거나 둘중 하나임 어차피 
                answer += 5;
                if(next >= 5){
                    storey += 5;
                }

            }
            
            
            storey /= 10;
        }

        
        return answer;
    }
}
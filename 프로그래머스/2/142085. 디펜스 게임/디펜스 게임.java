import java.util.*;

class Solution {
    
    
    // 앞에서 순차적으로 가다가 죽으면
    // 앞에 기록한것들 중 가장 큰것을 없애면 많이 가겠지 라는 그리디
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++){
            
            n -= enemy[i];
            pq.offer(enemy[i]);
            
            
            if(n < 0 ){
                
                if(k-- > 0)
                    n += pq.poll();
                else
                    break;
                
            }
            
            answer++;
            
        }
        
        
        return answer;
    }
}
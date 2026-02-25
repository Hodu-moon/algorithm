import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        int[] visited = new int[3000001];
        queue.offer(x);
        
        while( !queue.isEmpty()){
            int cur = queue.poll();
            
            if(cur == y){
                return visited[cur];
            }
            
            // 1, 2, 3
            int[] nexts = new int[]{ cur + n, cur * 2,cur * 3 };
            for(int next : nexts){
                
                if(visited[next] != 0 || next > y)
                    continue;
                
                queue.offer(next);
                visited[next] = visited[cur] + 1;
                    
            }
            
        }
        
      
        return -1;
    }
    

}
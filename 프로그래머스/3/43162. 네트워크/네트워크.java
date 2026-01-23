import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < computers.length; i++){
            if(visited[i])
                continue;
            
            answer++;
            solve(i, n, computers, visited);
        }
        
        
        return answer;
    }
    
    static void solve(int start, int n, int[][] computers, boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            
            for(int i = 0; i < n; i++){
                
                if(i == cur || visited[i])
                    continue;
                
                if(computers[cur][i] == 1){
                    visited[i] = true;
                    queue.offer(i);
                }
                
            }
        }
    }
}
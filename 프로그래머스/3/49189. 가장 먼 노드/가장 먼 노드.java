import java.util.*;

class Solution {
    // BFS 돌리기 
    
    static List<List<Integer>> list = new ArrayList<>();
    static int[] costs;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        costs = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++){
            // 양방향 
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        answer = bfs(n);
        
        return answer;
    }
    
    static int bfs(int n){
        
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        
        int score = 0;
        int num = 1;
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            score = size;
            
            System.out.println("num : " + num++ + " size : " + size);
            for(int i = 0; i < size; i++){
                
                // 탐색
                int current = queue.poll();
                System.out.println(current);
                
                for(int next : list.get(current)){
                    
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                    
                }

            }
            
            
            
        }
        
        return score;
        
    }

    
    
}
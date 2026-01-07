import java.util.*;

class Solution {
    
    static int result = Integer.MAX_VALUE;
    static List<List<Integer>> lines;

    public int solution(int n, int[][] wires) {
        int answer = 0;
        
        // 트리형태 - 다 연결
        // 2개로 나누면 한 뭉탱이 + 나머지 뭉탱이 = 전체
        
        // 한 뭉탱이  | n -cnt -cnt |
        
        
        lines = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            lines.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            lines.get(a).add(b);
            lines.get(b).add(a);
        }
        
        for(int i = 0; i < wires.length; i++){
            int A = wires[i][0];
            int B = wires[i][1];
            BFS(n, A, B);
        }
        
        return result;
    }
    
    static void BFS(int n, int start, int noNext){
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int next : lines.get(current)){
                
                if( (current == start && next == noNext) ||( current == noNext && next == start))
                    continue;
                
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
                
            }
        }
        
        // 두개의 차의 절댓값이 최소가 되게 
        int diff = Math.abs(n - cnt - cnt);
        
        result = Math.min(result, diff);
        
        
    }
    
    
}
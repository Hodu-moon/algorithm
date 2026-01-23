import java.util.*;

class Solution {
    static int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        
        
        List<List<Vertex>> edges = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            edges.add(new ArrayList<>());
        }
        
        
        for(int i = 0; i < road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            edges.get(from).add(new Vertex(to, weight));
            edges.get(to).add(new Vertex(from, weight));
        }
        
        // dist 배열, visited 
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        Queue<Vertex> pq = new PriorityQueue<Vertex>();
        // 시작 지점
        pq.offer(new Vertex(1, 0));
        
        for(int i = 2; i <= N; i++){
            pq.offer(new Vertex(i, INF));
        }
        
        // 이제 탐색 시작 
        while(!pq.isEmpty()){
            Vertex cur = pq.poll();
            
            if(visited[cur.no])
                continue;
            
            visited[cur.no] = true;
            dist[cur.no] = cur.weight;
            
            if( dist[cur.no] <= K){
                answer++;
            }
            
            for(Vertex next : edges.get(cur.no)){
                
                if(visited[next.no]){
                    continue;
                }
                // 방문 처리
                
                if(dist[next.no] > dist[cur.no] + next.weight){
                    dist[next.no] = dist[cur.no] + next.weight;
                    
                    pq.offer(new Vertex(next.no, dist[next.no]));
                }
            }
            
        }
        
        
        for(int i = 1; i <= N; i++){
            System.out.print(dist[i]  + " ");
        }
        
        
        
        return answer;
    }
    
    static class Vertex implements Comparable<Vertex> {
        int no, weight;
        
        Vertex(int no, int weight){
            this.no = no;
            this.weight = weight;
        }
        
        public int compareTo(Vertex o){
            return Integer.compare(this.weight, o.weight);
        }
        
        
    }
}
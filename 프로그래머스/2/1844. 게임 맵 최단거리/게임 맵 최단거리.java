import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        int answer = -1;
        // 10111
        // 10101
        // 10111
        // 11101
        // 00001
        
        // 0, 0 -> m-1, n-1 
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        queue.offer(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if(!isIn(maps, nx, ny))
                    continue;
                
                if(visited[nx][ny] || maps[nx][ny] == 0)
                    continue;
                
                if(nx == maps.length - 1 && ny == maps[0].length - 1 ){
                    return cur[2] + 1;
                    
                }
                
                queue.offer(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
                
            }
            
        }
        
        return answer;
    }
    
    static boolean isIn(int[][] maps, int x, int y){
        return 0 <= x && x < maps.length &&  0 <= y && y < maps[0].length ; 
    }
    
    
}
import java.util.*;

class Solution {
    
    static int[] values;
    static boolean[][] visited;
    static int landX;
    static int landY;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public int solution(int[][] land) {
        int answer = 0;
        landX = land.length;
        landY = land[0].length;
                values = new int[landX * landY + 2];        

        int num = 2;
        visited = new boolean[land.length][land[0].length];

        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(visited[i][j])
                    continue;
                
                if(land[i][j] == 1){
                    int score = bfs(land, i, j , num);
                    values[num++] = score;
                }
                
            }
        }
        
        //         for(int[] xx : land){
        //     for(int x : xx){
        //         System.out.print(x + " ");
        //     }
        //     System.out.println();
        // }
        // for(int i = 0; i < 10; i++){
        //     System.out.print(values[i] + " ");
        // }

        
        
        int max = -1;
        for(int y = 0; y < land[0].length; y++){
            Set<Integer> set = new HashSet<>();
            int score = 0;
            for(int x = 0; x < land.length; x++){
                if(land[x][y] > 1){
                    if(!set.contains(land[x][y])){
                        score += values[land[x][y]];
                        // System.out.println(values[land[x][y]]);
                        
                        set.add(land[x][y]);
                    }
                }
            }
            
            if(score > max){
                max = score;
            }
        }
        
        
        
        return max;
    }
    
    public static int bfs(int[][] land,int i, int j, int num){
        
        Queue<Point> pq = new ArrayDeque<>();
        int score = 1;
        pq.offer(new Point(i, j));
        land[i][j] = num;
        visited[i][j] = true;

        
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            
            
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if( !isIn(nx, ny) )
                    continue;
                
                if(visited[nx][ny])
                    continue;
                
                if(land[nx][ny] == 1){
                    visited[nx][ny] = true;
                    score++;
                    land[nx][ny] = num;
                    pq.offer(new Point(nx, ny));
                }

            }
              
        }
        
        return score;
        
    }
    
    
    static boolean isIn(int x, int y){
        return 0 <= x && x < landX && 0 <= y && y < landY;
    }
    
    
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
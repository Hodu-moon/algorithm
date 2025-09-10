import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> friendsMap = new HashMap<>();
        
        int index = 0;
        for(String friend : friends){
            friendsMap.put(friend, index++);
        }
        
        int[] jisu = new int[friends.length];
        int[][] matrix = new int[friends.length][friends.length];
        
        
        for(String gift: gifts){
            String[] g = gift.split(" ");
            
            // 1.지수 증가 
            // 선물을 주면 +1, 받으면 -1
            int giverIndex = friendsMap.get(g[0]);
            int receiverIndex = friendsMap.get(g[1]);
            
            
            jisu[giverIndex]++;
            jisu[receiverIndex]--;
            
            matrix[giverIndex][receiverIndex]++;
        }

        
        for(int i = 0; i < friends.length; i++){
            int iReceiveCount = 0;
            
            for(int j = 0; j < friends.length; j++){
                if(i == j)
                    continue;
                
                if(matrix[i][j] > matrix[j][i]){
                    iReceiveCount++;
                }else if(matrix[i][j] == matrix[j][i]){
                    
                    
                    if(jisu[i] > jisu[j]){
                        iReceiveCount++;
                    }
                    
                }
                
            }
            
            answer = Math.max(answer, iReceiveCount);
            
        }
        
        
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int lux = 1000000, luy = 1000000, rdx = -1, rdy = -1;
        
        
        for(int i = 0; i < wallpaper.length; i++){
            String input = wallpaper[i];
            
            for(int j = 0; j < input.length(); j++){
                char ch = input.charAt(j);
                
                if(ch == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j );
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy , j + 1);
                }
            }
            
            
        }
        
        
        return new int[]{lux, luy, rdx, rdy};
    }
}
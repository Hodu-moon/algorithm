import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> skipSet = new HashSet<>();
        for(int i = 0; i < skip.length(); i++){
            char c = skip.charAt(i);
            skipSet.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';

            int skipCount = 0;
            for(int j = 1; j <= index; j++){
                int newC = (c + j + skipCount) % 26 + 'a';
                
                if(skipSet.contains((char)(newC))){
                    skipCount++;
                    j--;
                }
                    
            }
            
            sb.append((char)( ( (c  + index+skipCount) % 26) + 'a' ) );
            
        }
        
        return sb.toString();
    }
}
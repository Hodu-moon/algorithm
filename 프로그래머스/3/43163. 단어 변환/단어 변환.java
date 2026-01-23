import java.util.*;

class Solution {
    
    static class Node{
        String word;
        int edge;
        
        Node(String word, int edge){
            this.word = word;
            this.edge = edge;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean hasTarget = false;
        
        for(String word : words){
            if(target.equals(word)){
                hasTarget = true;
                break;
            }
        }
        
        if(!hasTarget){
            return 0;
        }
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));
        
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            if(cur.word.equals(target)){
                return cur.edge;
            }
            
            for(int i = 0; i < words.length; i++){
                
                // 방문처리
                
                // 갈 수 있는지 , 
                
                if(!visited[i] && canConvert(cur.word, words[i])){
                    
                    visited[i] = true;
                    queue.offer(new Node(words[i], cur.edge + 1));
                }
                
                
                
            }
            
            
        }
        
        
        
        
        return answer;
    }
    
    static boolean canConvert(String source, String target){
        
        int diff = 0;
        
        for(int i = 0; i < source.length(); i++){
            char s = source.charAt(i);
            char c = target.charAt(i);
            
            if( s != c)
                diff++;
            
        }
        
        return diff == 1;
    }
}
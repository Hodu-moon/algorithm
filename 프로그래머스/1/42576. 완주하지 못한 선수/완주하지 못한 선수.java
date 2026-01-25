import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String participant : participants){
            int count = map.getOrDefault(participant, 0);
            map.put(participant, count + 1);
        }
        
        for(String completion : completions){
            map.put(completion, map.get(completion) - 1);
        }
        
        for(String key : map.keySet()){
            int count = map.get(key);
            if(count != 0){
                return key;
            }
        }
        return answer;
    }
}
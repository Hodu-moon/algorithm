import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        
        for(String phone : phone_book){
            set.add(phone);
        }
        
        boolean flag = true;
        
        for(String phone : phone_book){
            
            for(int i = 1; i < phone.length(); i++){
                if(set.contains(phone.substring(0, i))){
                    flag = false;
                    break;
                }
            }
            
            if(!flag){
                break;
            }
        }
        
        
    
        return flag;
    }
}
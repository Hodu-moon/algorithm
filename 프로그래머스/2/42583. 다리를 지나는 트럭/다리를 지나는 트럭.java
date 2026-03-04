class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
    
        if(truck_weights.length == 1){
            return bridge_length + 1;
        }
        
        // 현재 다리 위 트럭 무게 합
        int[] end = new int[truck_weights.length];
        int cur = truck_weights[0];
        end[0] = bridge_length;
        
        int cnt = 1;
        int i = 1;
        int end_i = 0;
        for(; i < truck_weights.length ; cnt++){
            
            if(cnt == end[end_i]){
                cur -= truck_weights[end_i++];
            }
            
            if(cur + truck_weights[i] > weight){
                continue;
            }
            
            end[i] = cnt + bridge_length;
            cur += truck_weights[i++];
            
            
        }
        
      
        
        return end[truck_weights.length - 1] + 1;
    }
}
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long start = 1L;
        long end = (long)times[times.length - 1] * n;
        
        while(start < end){
            
            long mid = (start + end) / 2;
            
            long cnt = 0;
            
            for(int time : times){
                cnt += (mid / time);
            }
            
            // 만약 합이 원래 구하려고 작다면 시간이 늘어야 함
            if(cnt < n){
                start = mid + 1;
            }else{
                end = mid;
            }
            
        }
        
        
        return start;
    }
}
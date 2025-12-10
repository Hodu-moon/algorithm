class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            
            int schedule = schedules[i];
            boolean flag = true;
            
            int si = schedule / 100;
            int bun = schedule % 100;
            
            
            bun += 10;
            
            if(bun >= 60){
                bun = bun % 60;
                si++;
                
                // 시 도 생각
            }
            
            int target = si * 100 + bun ;
            
            System.out.println(target);
            
            int day = startday;
            for(int j = 0; j < 7; j++){
                if(day == 6 ){
                    day++;
                    continue;
                }
                
                if(day == 7){
                    day = 1;
                    continue;
                }
                
                int time = timelogs[i][j];
                
                if(time > target){
                    flag = false;
                    break;
                }
                
                day++;
                
            }
            
            if(flag){
                answer++;
            }
            
            
        }
        
        
        
        return answer;
    }
}
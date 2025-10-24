class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_len_int =  convertStringToInt(video_len);
        int pos_int =  convertStringToInt(pos);
        int op_start_int =  convertStringToInt(op_start);
        int op_end_int = convertStringToInt(op_end);
        
        int result = pos_int;
        
        if(op_start_int <= result && result <= op_end_int){
              result = op_end_int;
        }
        
        for(String command : commands){
            
            if(command.equals("next")){

                if( video_len_int - result < 10){
                    result = video_len_int;
                }else{
                    result += 10;
                }
                
            }else if(command.equals("prev")){

                if(result < 10){
                    result = 0;
                }else{
                    result -= 10;
                }
            }
            
            if(op_start_int <= result && result <= op_end_int){
                result = op_end_int;
            }
            
            
            
        }
        
        System.out.println( String.format("%02d:%02d", result / 60 , result % 60));
        
        
        
        return String.format("%02d:%02d", result / 60 , result % 60);
    }
    
    static int convertStringToInt(String stringTime){
        int time = 0;
        String[] split = stringTime.split(":");
        time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        
        
        return time;
    }
}
class Solution {
    static int N , result;
    static int[] arr;
    static int[] nums;
    public int solution(int[] number) {
        int answer = 0;
        
        N = number.length;
        arr = new int[3];
        nums = number;
        combination(0, 0);
        
        return result;
    }
    
    public void combination(int depth, int startWith){
        if(depth == 3){
            
            int sum = 0;
            
            for(int i : arr){
                sum += nums[i];
            }
        
            
            if(sum == 0){
                result++;
            }
            
            return;
        }
        
        
        for(int i = startWith; i < N; i++ ){
            arr[depth] = i;
            combination(depth + 1, i + 1);
        }
        
    }
}
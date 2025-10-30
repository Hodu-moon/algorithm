class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int rest = 0;
        
        int cnt = 20;

        while (true){
            if(n < a){
                break;
            }
            
            // if(cnt-- == 0){
            //     break;
            // }
            
            
            int value = ((n / a) * b);
            answer += value;
            rest = n % a;
            n = value + rest;
            System.out.println("answer : " + answer);
            System.out.println("n : " + n);
            System.out.println("rest : " + rest);
            
        }
        
        
        return answer;
    }
}
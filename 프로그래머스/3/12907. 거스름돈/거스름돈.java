class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - m]) % 1000000007;
            }
        }
        
        return dp[n];
    }
}
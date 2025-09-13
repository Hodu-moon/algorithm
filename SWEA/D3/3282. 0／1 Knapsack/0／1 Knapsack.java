
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 물건 번호
            int K = Integer.parseInt(st.nextToken()); // 부피

            int[] V = new int[N + 1];
            int[] C = new int[N + 1];

            int[][] dp = new int[N+1][K + 1];

            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            // 이제 뽑아야지
            for(int i = 1; i <= N; i++ ){
                for(int j = 1; j <= K; j++){ // j -> 현재 가방의
                    // 1. 선택 i 번째 물건을 선택 안한 경우
                    dp[i][j] = dp[i - 1][j];


                    // 2. i 번째 물건을 선택안한 경우

                    if( j - V[i] >= 0 ) //  현재 가방의 부피 - i번쨰 아이템의 부피
                         dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - V[i]] + C[i]);

                }
            }

            System.out.println("#" + t + " " + dp[N][K]);

        }
    }
}

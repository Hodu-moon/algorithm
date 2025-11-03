import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, I;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N + 1][M + 1];
        int[][] vertical = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++ ){
            for(int j =1; j <= M; j++){
                // 1. 수직 방향
                vertical[i][j] = matrix[i][j] + vertical[i - 1][j];

                // 2. 낄낄
                result[i][j] = vertical[i][j] + result[i - 1][j - 1];
            }
        }



        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < I; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) ;
            int y = Integer.parseInt(st.nextToken());

            sb.append(result[x][y]).append("\n");
        }

        System.out.println(sb);




    }
}
//4 5 3
//1 2 3 4 5
//5 2 1 4 6
//0 2 4 2 1
//0 0 2 1 7
//3 3
//1 4
//3 1

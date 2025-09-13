
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int MOD = 20171109;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int N, answer, first;
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            first = Integer.parseInt(st.nextToken());

            Queue<Integer> leftHeap = new PriorityQueue<>(((o1, o2) -> o1 - o2));
            Queue<Integer> rightHeap = new PriorityQueue<>((o1, o2) -> -1 * (o1 - o2));

            answer = 0;
            // 큰 쪽에 하나 더 넣기
            rightHeap.add(first);

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if( num1 > num2){
                    leftHeap.add(num2);
                    rightHeap.add(num1);
                }else{
                    leftHeap.add(num1);
                    rightHeap.add( num2);
                }

                int min = rightHeap.peek();
                int max = leftHeap.peek();

                if(min > max){
                    int left = leftHeap.poll();
                    int right = rightHeap.poll();
                    leftHeap.add(right);
                    rightHeap.add(left);
                }

                int middle = rightHeap.peek();

                answer =  ((answer + middle)  % MOD);

            }

            System.out.println("#"+ t + " " + answer);



        }


    }
}

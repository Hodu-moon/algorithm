import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// 1.
public class Main{
    static int N;
    static int M;
    static int[] orders;

    // 자리가 부족하다면 제일 나중에 사용되는 콘센트 뽑기

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        orders = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            orders[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> multiTab = new HashSet<>();

        int currentCount = 0;
        int answer = 0;

        for(int i = 0; i < M; i++){
            int cur = orders[i];

            // 이미 포함하고 있다면 넘겨도 되자나
            if(multiTab.contains(cur)){
                continue;
            }

            // 컨센트 수가 남아있다면 넘겨버려~
            if(currentCount < N){
                currentCount++;
                multiTab.add(cur);
                continue;
            }

            // 이제 컨센트가 부족함
            // 1.현재 꽂혀 있는데 뒤에 쭉 안쓰는 친구가 찾기 // 아무거나


            Set<Integer> notUsed = new HashSet<>(multiTab);
            // 현재 꽂혀있는 애들 - 뒤에 꽂혀있는 애들
            // 나중에 안쓰는 애들 나옴
            for(int j = i + 1; j < M; j++){
                int next = orders[j];
                if(multiTab.contains(next)){
                    notUsed.remove(next);
                }
            }

            // 뒤에 안쓰는 친구 있으면
            if(!notUsed.isEmpty()){
                int not = (int)notUsed.toArray()[0];
                multiTab.remove(not);
                answer++;
                multiTab.add(cur);

            }else{ // 안쓰는 친구가 없었다면 뒤에꺼

                // 모두 뒤에 다시 쓰인다면
                // 다음 사용 시간이 가장 먼 곳을 골라야 하지

                int victim = -1;
                int farthest = -1;
                for(int plugged : multiTab){
                    int when = Integer.MAX_VALUE;


                    for(int j = i + 1; j < M; j++){
                        if(orders[j] == plugged){
                            when = j;
                            break;
                        }
                    }

                    if(when > farthest){
                        farthest = when;
                        victim = plugged;
                    }
                }

                multiTab.remove(victim);
                answer++;
                multiTab.add(cur);



            }



        }

        System.out.println(answer);



    }
}

//2 7
//2 3 2 3 1 2 7

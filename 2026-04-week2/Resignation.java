import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resignation {
// 문제
// 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
// 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
// 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
// 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
// 상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
// 둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)

// 출력
// 첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] work = new int[n+1][2];
        int[] dp = new int[n+2];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }


        for(int i = n; i >= 1; i--){
            if(i + work[i][0] > n+1){
                dp[i] = dp[i+1];
            }else{
                dp[i] = Math.max(work[i][1] + dp[i+work[i][0]],dp[i+1]);
            }
        }
        System.out.println(dp[1]);

        
    }
}

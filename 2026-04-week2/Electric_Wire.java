import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Electric_Wire {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        int[] dp = new int[n+1];


        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        for(int i = 1; i <= n; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(arr[i][1] > arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }

        System.out.println(n-max);
        
    }
}

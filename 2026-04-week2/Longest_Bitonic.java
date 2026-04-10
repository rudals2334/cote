import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Longest_Bitonic {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] inc = new int[n+1];
        int[] dec = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            inc[i] = 1;
            for(int j = 1; j < i; j++){
                if(arr[j] < arr[i]){
                    inc[i] = Math.max(inc[i], inc[j]+1);
                }
            }
        }

        for(int i = n; i >= 1; i--){
            dec[i] = 1;
            for(int j = n; j > i; j--){
                if(arr[i] > arr[j]){
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            dp[i] = inc[i] + dec[i] - 1;
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }  
}

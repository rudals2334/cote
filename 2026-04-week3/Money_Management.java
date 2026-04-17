import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Money_Management {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        int max = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            money[i] = Integer.parseInt(br.readLine());
            sum += money[i];
            if(money[i] > max){
                max = money[i];
            }
        }

        int left = max;
        int right = sum;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 1;
            int a = mid;
            for(int i = 0; i < n; i++){
                if(a>=money[i]){
                    a -= money[i];
                }else{
                    cnt++;
                    a = mid - money[i];
                }
            }

            if(cnt <= m){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            } 
        }
        System.out.println(answer);
    }
}

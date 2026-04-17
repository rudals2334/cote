import java.io.*;
import java.util.*;

public class Cut_LAN_Cable {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lan = new int[k];
        int max = 0;
        for(int i = 0; i < k; i++){
            lan[i] = Integer.parseInt(br.readLine());
            if(lan[i] > max){
                max = lan[i];
            }
        }

        long left = 1;
        long right = max;
        long answer = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < k; i++){
                long a = lan[i] / mid;
                sum += a;
            }
            if(sum >= n){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

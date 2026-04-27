import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sum_Two_Number {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int x = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 2; i < n; i++){
            while(left<right){
                if(arr[left] + arr[right] == x){
                    cnt++;
                    right--;
                }else if(arr[left] + arr[right] > x){
                    right--;
                }else{
                    left++;
                }
            }
        }
        System.out.println(cnt);
        
    }
}

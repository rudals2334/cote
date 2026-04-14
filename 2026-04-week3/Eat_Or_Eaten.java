import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Eat_Or_Eaten {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] one = new int[n];
            int[] two = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                one[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                two[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(one);
            Arrays.sort(two);

            int cnt = 0;
            for(int j = 0; j < n; j++){
                cnt += binarySearch(one[j], two);
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    public static int binarySearch(int a, int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int answer = arr.length;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= a){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
}

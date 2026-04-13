import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number_Card {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        int m = Integer.parseInt(br.readLine());
        int[] compare = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            compare[i] = Integer.parseInt(st2.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            sb.append(binarySearch(card, compare[i]));
            sb.append(" ");
        }
        System.out.println(sb);
        
    }
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }
}

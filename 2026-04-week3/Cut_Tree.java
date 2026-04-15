import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cut_Tree {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        int left = 0;
        int right = max;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            long sum = 0;
            for(int i = 0; i < n; i++){
                if(tree[i] > mid)
                sum += tree[i] - mid;
            }

            if(sum >= m){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

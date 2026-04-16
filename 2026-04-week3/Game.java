import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int)((long)y * 100 / x);

        if(z >= 99){
            System.out.println(-1);
            return;
        }
        int left = 0;
        int right = (int)1e9;
        int answer = -1;

        while(left <= right){
            int mid = (left + right) / 2;
            int newRate = (int)((long)(y + mid)*100 / (x + mid));
            if(newRate==z){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class budget {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int budget = Integer.parseInt(br.readLine());
        int[] team = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            team[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(team);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            budget -= team[i];
            if(budget<0){
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
    
}

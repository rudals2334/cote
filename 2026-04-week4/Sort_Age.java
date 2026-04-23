import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort_Age {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            arr[i][0] = age;
            arr[i][1] = name;
        }
       
        Arrays.sort(arr, (a,b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.print(sb);   
    }
}

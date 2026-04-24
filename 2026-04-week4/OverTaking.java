import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverTaking {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map_in = new HashMap<>();
        for(int i = 0; i < n; i++){
            map_in.put(br.readLine(), i+1);
        }
        String[] arr_out = new String[n];
        for(int i = 0; i < n; i++){
            arr_out[i] = br.readLine(); 
        }

        int cnt = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(map_in.get(arr_out[i]) > map_in.get(arr_out[j])){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
        
    }
}

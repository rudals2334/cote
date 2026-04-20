import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Neve_Heard_Of_It {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n+m];
        for(int i = 0; i < (n + m); i++){
            arr[i] = br.readLine();
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 2){
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String s : list){
            System.out.println(s);
        }

        
    }
}

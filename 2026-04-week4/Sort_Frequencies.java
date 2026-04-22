import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Sort_Frequencies {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(!map2.containsKey(num)){
                map2.put(num, i+1);
            }
            
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a,b) -> {
            if(!map.get(a).equals(map.get(b))){
                return map.get(b) - map.get(a);
            }
            return map2.get(a) - map2.get(b);
        });

        StringBuilder sb = new StringBuilder();
        for(int s : list){
            for(int i = 0; i < map.get(s); i++){
                sb.append(s).append(" ");
            }
        }
        System.out.println(sb);

        
    }
}

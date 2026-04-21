import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class MemorizingWords {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            if(word.length()>=m){
                map.put(word, map.getOrDefault(word,0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> {
            // 빈도수 내림차순
            if(!map.get(a).equals(map.get(b))){
                return map.get(b) - map.get(a);
            }
            // 단어 길이 내림차순
            if(a.length()!=b.length()){
                return b.length() - a.length();
            }
            // 사전순
            return a.compareTo(b);
        });
        StringBuilder sb = new StringBuilder();
        for(String a : list){
            sb.append(a).append('\n');
        }
        System.out.println(sb);
        
    }
}

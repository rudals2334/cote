import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Ecology {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();

        String line;
        int total = 0;
        while((line = br.readLine()) != null){
            if(line.isEmpty()) continue;

            map.put(line, map.getOrDefault(line, 0) + 1);
            total++;
        }

        for(String key : map.keySet()){
            double ratio = (map.get(key) * 100.0) / total;
            System.out.printf("%s %.4f\n", key, ratio);
        }
    }
}

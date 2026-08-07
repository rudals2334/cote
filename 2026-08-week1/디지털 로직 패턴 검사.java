import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s, int k, int m) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length() - k; i++) {
            String str = s.substring(i, i + k);

            int count = map.getOrDefault(str, 0) + 1;

            if (count >= m) {
                return 1;
            }

            map.put(str, count);
        }

        return 0;
    }
}
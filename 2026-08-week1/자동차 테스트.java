import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int n, int q, int[] car, int[] now) {
        Arrays.sort(car);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(car[i], i);
        }

        int[] answer = new int[q];

        for (int i = 0; i < q; i++) {
            if (map.containsKey(now[i])) {
                int idx = map.get(now[i]);
                answer[i] = idx * (n - idx - 1);
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}
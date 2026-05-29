import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();

        for(int s : topping){
            right.put(s, right.getOrDefault(s, 0) + 1);
        }

        for(int i = 0; i < topping.length - 1; i++){
            left.add(topping[i]);
            right.put(topping[i], right.get(topping[i]) - 1);
            if(right.get(topping[i]) == 0){
                right.remove(topping[i]);
            }
            if(left.size() == right.size()){
                answer ++;
            }
        }
        return answer;
    }
}
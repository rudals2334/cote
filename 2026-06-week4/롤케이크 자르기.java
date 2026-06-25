import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> chulsoo = new HashMap<>();
        Map<Integer, Integer> brother = new HashMap<>();
        for(int s : topping){
            brother.put(s, brother.getOrDefault(s,0)+1);
        }

        for(int i = 0; i < topping.length; i++){
            chulsoo.put(topping[i], chulsoo.getOrDefault(topping[i], 0)+1);
            brother.put(topping[i], brother.get(topping[i]) - 1);
            if(brother.get(topping[i]) == 0){
                brother.remove(topping[i]);
            }
            if(chulsoo.size() == brother.size()){
                answer++;
            }
        }
        return answer;
    }
}
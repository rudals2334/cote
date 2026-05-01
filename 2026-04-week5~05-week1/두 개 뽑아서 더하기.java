import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                int a = numbers[i] + numbers[j];
                set.add(a);
            }
        }

        int len = set.size();
        Integer[] temp = set.toArray(new Integer[0]);
        int[] answer = new int[len];
        
        for(int i = 0; i < temp.length; i++){
            answer[i] = temp[i];
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
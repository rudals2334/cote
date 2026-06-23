import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                Integer a = numbers[i] + numbers[j];
                set.add(a);
            }
        }
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        int[] answer = new int[arr.length];
        int i = 0;
        for(int a : arr){
            answer[i] = a;
            i++;
        }
        return answer;
    }
}
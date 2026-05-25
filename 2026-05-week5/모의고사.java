import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == arr1[i % arr1.length]){
                cnt1++;
            }
            if(answers[i] == arr2[i % arr2.length]){
                cnt2++;
            }
            if(answers[i] == arr3[i % arr3.length]){
                cnt3++;
            }
        }

        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        List<Integer> list = new ArrayList<>();

        if(max == cnt1){
            list.add(1);
        }
        if(max == cnt2){
            list.add(2);
        }
        if(max == cnt3){
            list.add(3);
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
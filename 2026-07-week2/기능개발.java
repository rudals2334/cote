import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        for(int i = 0; i < arr.length; i++){
            int remain = 100 - progresses[i];
            if(remain % speeds[i] != 0){
                arr[i] = remain / speeds[i] + 1;
            }else{
                arr[i] = remain / speeds[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        int a = arr[0];
        int cnt = 1;
        for(int i = 1; i < progresses.length; i++){
            if(a >= arr[i]){
                cnt++;
            }else{
                list.add(cnt);
                cnt = 1;
                a = arr[i];
            }
        }
        list.add(cnt);

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
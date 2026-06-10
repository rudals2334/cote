import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];

            if(remain % speeds[i] != 0){
                arr[i] = remain / speeds[i] + 1;
            }else{
                arr[i] = remain / speeds[i];
            }
        }

        List<Integer> list = new ArrayList<>();

        int cnt = 1;
        int f = arr[0];

        for(int i = 1; i < arr.length; i++){     
            if(f < arr[i]){
                list.add(cnt);
                cnt = 1;
                f = arr[i];
            }else{
                cnt++;
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
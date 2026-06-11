import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }

        int i = 0;
        int answer = 0;
        int on_weight = 0;

        while(i < truck_weights.length){
            answer++;
            on_weight -= q.poll();

            if(on_weight + truck_weights[i] <= weight){
                q.offer(truck_weights[i]);
                on_weight += truck_weights[i];
                i++;
            }else{
                q.offer(0);
            }
        }

        return answer + bridge_length;
    }
}
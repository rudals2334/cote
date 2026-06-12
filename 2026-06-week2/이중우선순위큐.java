import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq_reverse = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; i++){
            if(operations[i].charAt(0) == 'I'){
                pq.add(Integer.parseInt(operations[i].substring(2,operations[i].length())));
                pq_reverse.add(Integer.parseInt(operations[i].substring(2,operations[i].length())));
            }else{
                if(pq.isEmpty()) continue;
                if(operations[i].charAt(2) == '-'){
                    int min = pq.poll();
                    pq_reverse.remove(min);
                }else{
                    int max = pq_reverse.poll();
                    pq.remove(max);
                }
            }
        }

        if(pq.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{pq_reverse.peek(), pq.peek()};
        }
    }
}
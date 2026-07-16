import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }
        while(n > 0 && !pq.isEmpty()){
            int a = pq.poll();
            a--;
            if(a!=0){
                pq.offer(a);
            }
            n--;
        }

        long answer = 0;
        if(pq.isEmpty()){
            return 0;
        }
        while (!pq.isEmpty()) {
            answer += (long)Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}
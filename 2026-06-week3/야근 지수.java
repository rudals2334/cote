import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }

        while(!pq.isEmpty() && n > 0){
            int a = pq.poll() - 1;
            if(a!=0){
                pq.offer(a);
            }
            n--;
        }
        
        long answer = 0;

        if(pq.isEmpty()){
            return 0;
        }else{
            while(!pq.isEmpty()){
                long k = pq.peek();
                k *= k;
                answer += k;
                pq.poll();
            }
            return answer;
        }
    }
}
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }

        int low = pq.peek();
        int answer = 0;
        while(low < K){
            if(pq.size()>=2){
                int a = pq.poll();
                int b = pq.poll();
                int c = a + (b * 2);
                pq.offer(c);
                low = pq.peek();
                answer++;
            }
            else return -1;
        }
        return answer;
    }
}
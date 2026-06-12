import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }

        int answer = 0;

        while (pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            int new_one = a + (b*2);
            pq.add(new_one);
            answer++;
        }

        if(pq.peek() >= K){
            return answer;
        }else{
            return -1;
        }
    }
}
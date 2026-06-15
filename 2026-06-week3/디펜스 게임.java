import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for(int i = 0; i < enemy.length; i++){
            pq.offer(enemy[i]);
            
            if(pq.size() > k){
                int a = pq.poll();
                if(n < a){
                    break;
                }
                n -= a;
            }
            answer++;
        }
        return answer;
    }
}
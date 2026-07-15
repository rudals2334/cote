import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> re_pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; i++){
            String[] arr = operations[i].split(" ");
            if(arr[0].equals("I")){
                Integer a = Integer.parseInt(arr[1]);
                pq.offer(a);
                re_pq.offer(a);
            }else{
                if(pq.isEmpty()) continue;
                if(arr[1].equals("-1") ){
                    int k = pq.poll();
                    re_pq.remove(k);
                }else{
                    int k = re_pq.poll();
                    pq.remove(k);
                }
            }
        }
        int[] answer = new int[2];

        if(pq.isEmpty()){
            return new int[]{0,0};
        }else{
            answer[0] = re_pq.poll();
            answer[1] = pq.poll();
            return answer;
        }
    }
}
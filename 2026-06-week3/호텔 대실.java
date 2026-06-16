import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time,(a,b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < book_time.length; i++){
            int check_in = Integer.parseInt(book_time[i][0].substring(0,2)) * 60 + 
                            Integer.parseInt(book_time[i][0].substring(3,5));
                            
            int check_out = Integer.parseInt(book_time[i][1].substring(0,2)) * 60 + 
                            Integer.parseInt(book_time[i][1].substring(3,5));
            
            if(!pq.isEmpty() && pq.peek() <= check_in){
                pq.poll();
            }
            pq.offer(check_out + 10);
        }

        int answer = pq.size();
        return answer;
    }
}
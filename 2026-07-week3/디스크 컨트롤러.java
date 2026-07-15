import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs){
        Arrays.sort(jobs,(a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int cnt = 0;
        int time = 0;
        int sum = 0;
        int idx = 0;

        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(jobs[idx]);
                idx++;
            }
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                time += job[1];
                sum += time - job[0];
                cnt++;
            }else{
                time = jobs[idx][0];
            }
        }
        return sum / jobs.length;
    }
}
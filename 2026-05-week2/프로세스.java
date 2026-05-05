import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            int file = priorities[i];
            q.offer(new int[] {file,i});
        } 

        int cnt = 0;
        while(true){
            int cur[] = q.poll();
            boolean hasBigger = false;
            for(int doc[] : q){
                if(doc[0] > cur[0]){
                    hasBigger = true;
                    break;
                }
            }
            if(hasBigger){
                q.offer(cur);
            }else{
                cnt++;
                if(cur[1] == location){
                    return cnt;
                }
            }
        }
    }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;
    public int solution(int x, int y, int n) {
        visited = new boolean[y+1];
        return bfs(x, y, n);
    }
    public int bfs(int x, int y, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int current = queue.poll();
                if(current == y){
                    return cnt;
                }
                int[] next = {current + n, current * 2, current * 3};
                for(int num : next){
                    if(num > y){
                        continue;
                    }
                    if(visited[num]){
                        continue;
                    }
                    visited[num] = true;
                    queue.add(num);
                }
            }
            cnt++;
        }
        return -1;
    }
}
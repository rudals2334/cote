import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        String[] word = new String[words.length + 1];
        word[0] = begin;
        for(int i = 0; i < words.length; i++){
            word[i+1] = words[i];
        }
        for(int i = 0; i < word.length; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[word.length];

        for(int i = 0; i < word.length-1; i++){
            for(int j = i+1; j < word.length; j++){
                int cnt = 0;
                for(int k = 0; k < word[i].length(); k++){
                    if(word[i].charAt(k) != word[j].charAt(k)){
                        cnt++;
                    }
                }
                if(cnt==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        return bfs(target, word);
    }
    
    public int bfs(String target, String[] word){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int current = now[0];
            int count = now[1];

            if(word[current].equals(target)){
                return count;
            }

            for(int i = 0; i < graph.get(current).size(); i++){
                int next = graph.get(current).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, count + 1});
                }
            }
        }
        return 0;
    }
}
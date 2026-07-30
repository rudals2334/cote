import java.util.ArrayList;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int answer;
    public int solution(int[] info, int[][] edges) {
        for(int i = 0; i < info.length; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
        }
        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);
        answer = 0;
        dfs(0, 0, next, info);
        return answer;
    }
    public void dfs(int sheep, int wolf, ArrayList<Integer> next, int[] info){
        for(int i = 0; i < next.size(); i++){
            ArrayList<Integer> newNext = new ArrayList<>(next);
            int x = newNext.remove(i);
            int newSheep = sheep;
            int newWolf = wolf;
            if(info[x] == 0){
                newSheep++;
            }else{
                newWolf++;
            }
            if(newWolf >= newSheep) continue;

            answer = Math.max(answer, newSheep);

            for(int child : graph.get(x)){
                newNext.add(child);
            }
            dfs(newSheep, newWolf, newNext, info);
        }
    }
}
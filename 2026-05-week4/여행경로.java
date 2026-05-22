import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets,(a,b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        boolean[] visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();

        dfs("ICN", path, 0, tickets, visited);
        return path.toArray(new String[0]);
    }

    public static boolean dfs(String now, List<String> path, int depth, String[][] tickets, boolean[] visited){
        path.add(now);

        if(depth == tickets.length){
            return true;
        }

        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(now)){
                visited[i] = true;
                if(dfs(tickets[i][1], path, depth + 1, tickets, visited)){
                    return true;
                }
                visited[i] = false;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }    
}
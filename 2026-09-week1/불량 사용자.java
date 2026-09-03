import java.util.HashSet;
import java.util.Set;
class Solution {
    static boolean[] visited;
    static int answer;
    static Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        answer = 0;
        dfs(0, user_id, banned_id);
        return set.size();
    }
    
    public boolean match(String user, String banned){
        if(user.length() != banned.length()){
            return false;
        }

        for(int i = 0; i < user.length(); i++){
            char a = user.charAt(i);
            char b = banned.charAt(i);
            if(a!=b){
                if(b!='*'){
                    return false;
                }
            }
        }
        return true;
    }

    public void dfs(int depth, String[] user_id, String[] banned_id){
        if(depth == banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }
            set.add(String.valueOf(sb));
            return;
        }
        for(int i = 0; i < user_id.length; i++){
            if(visited[i]) continue;
            if(match(user_id[i], banned_id[depth])){
                visited[i] = true;
                dfs(depth+1, user_id, banned_id);
                visited[i] = false;
            }
        }
    }
}
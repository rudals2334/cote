import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs("", numbers);
        int answer = 0;
        for(int num : set){
            if(isprime(num)){
                answer ++;
            }
        }
        return answer;
    }

    public void dfs(String current, String numbers){
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }

        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;

            visited[i] = true;
            dfs(current + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }

    public boolean isprime(int n){
        if(n < 2){
            return false;
        }

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static int answer;
    public static int solution(String numbers){
        answer = 0;
        visited = new boolean[numbers.length()];
        int[] arr = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            arr[i] = Integer.parseInt(numbers.substring(i,i+1));
        }
        dfs("", arr);
        return set.size();
    }

    
    public static void dfs(String now, int[] arr ){
        if(!now.equals("")){
            if(isPrime(Integer.parseInt(now))){
                set.add(Integer.parseInt(now));
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(visited[i]) continue;

            visited[i] = true;
            dfs(now + String.valueOf(arr[i]), arr);
            visited[i] = false;
        }
    }

    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i <= n/2; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];
        for(int i = 1; i <= 8; i++){
            dp[i] = new HashSet<>();
        }

        for(int i = 1; i <= 8; i++){
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < i; k++){
                sb.append(N);
            }
            int connected = Integer.parseInt(sb.toString());
            dp[i].add(connected);
            for(int j = 1; j < i; j++){
                for(int a : dp[j]){
                    for(int b : dp[i-j]){
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(a*b);
                        if(b != 0){
                            dp[i].add(a/b);
                        }
                    }
                }
            }
            if(dp[i].contains(number)){
                return i;
            }
        }
        return -1;
    }
}
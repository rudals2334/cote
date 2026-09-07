class Solution {
    static int maxdiff;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        maxdiff = 0;
        int[] lion = new int[11];
        answer = new int[11];
        dfs(0, 0, n, lion, info);

        if(maxdiff == 0){
            return new int[]{-1};
        }
        return answer;
    }
    public void dfs(int idx, int arrow, int n, int[] lion, int[] info){
        if(idx == 10){
            lion[10] = n - arrow;

            int lionScore = 0;
            int appeachScore = 0;
            
            for(int i = 0; i < 11; i++){
                int score = 10-i;
                if(lion[i] == 0 && info[i] == 0) continue;
                if(lion[i] > info[i]){
                    lionScore += score;
                }else{
                    appeachScore += score;
                }
            }

            int diff = lionScore - appeachScore;
            if(diff > 0){
                if(diff > maxdiff){
                    maxdiff = diff;
                    answer = lion.clone();
                }else if(diff == maxdiff){
                    for(int i = 10; i >= 0; i--){
                        if(lion[i] > answer[i]){
                            answer = lion.clone();
                            break;
                        }else if(lion[i] < answer[i]){
                            break;
                        }
                    }
                }
            }
            lion[10] = 0;
            return;
        }
        int need = info[idx] + 1;
        if(arrow + need <= n){
            lion[idx] = need;
            dfs(idx+1, arrow+need, n, lion, info);
            lion[idx] = 0;
        }
        dfs(idx+1, arrow, n, lion, info);
    }
}
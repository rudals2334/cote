import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int num = score.length / m;
        int[][] box = new int[num][m];
        int a = score.length-1;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < m; j++){
                box[i][j] = score[a];
                a--;
            }
        }
        int answer = 0;
        for(int i = 0; i < num; i++){
            answer += box[i][m-1] * m;
        }
        return answer;
    }
}
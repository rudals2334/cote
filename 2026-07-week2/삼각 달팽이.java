class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int a = -1;
        int b = 0;
        int c = n;
        int num = 1;
        for(int i = 0; i < n; i++){
            int k = i % 3;
            for(int j = c; j > 0; j--){
                a += dx[k];
                b += dy[k];
                arr[a][b] = num++;
            }
            c--;
        }

        int[] answer = new int[(n*(n+1))/2];
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <arr[i].length; j++){
                if(arr[i][j] != 0){
                    answer[idx++] = arr[i][j];
                }
            }
        }
        return answer;
    }
}
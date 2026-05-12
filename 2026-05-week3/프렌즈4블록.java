class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        for(int i = 0; i < m; i++){
            arr[i] = board[i].toCharArray();
        }

        while(true){
            boolean[][] visited = new boolean[m][n];
            boolean found = false;

            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    char s = arr[i][j];

                    if(s!='.' &&
                        arr[i + 1][j] == s &&
                        arr[i][j + 1] == s &&
                        arr[i + 1][j + 1] == s){
                            visited[i][j] = true;
                            visited[i+1][j] = true;
                            visited[i][j+1] = true;
                            visited[i+1][j+1] = true;
                            found = true;
                    }
                }
            }

            if(!found){
                break;
            }

            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j]){
                        arr[i][j] = '.';
                        answer++;
                    }
                }
            }

            for(int j = 0; j < n; j++){
                int bottom = m-1;
                for(int i = m-1; i >= 0; i--){
                    if(arr[i][j]!='.'){
                        arr[bottom][j] = arr[i][j];

                        if(bottom!=i){
                            arr[i][j] = '.';
                        }
                        bottom --;
                    }
                }
            }
        }

        return answer;
    }
}
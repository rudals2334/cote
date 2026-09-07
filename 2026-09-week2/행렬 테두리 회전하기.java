class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int temp = 0;
        int[][] board = new int[rows][columns];
        int num = 1;
        int[] answer = new int[queries.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            temp = board[x1][y1];
            int min = temp;
            //윗변
            for(int y = y1; y < y2; y++){
                int next = board[x1][y+1];
                board[x1][y+1] = temp;
                temp = next;
                min = Math.min(min, temp);
            }
            //오른쪽변
            for(int x = x1; x < x2; x++){
                int next = board[x+1][y2];
                board[x+1][y2] = temp;
                temp = next;
                min = Math.min(min, temp);
            }
            //아랫변
            for(int y = y2; y > y1; y--){
                int next = board[x2][y-1];
                board[x2][y-1] = temp;
                temp = next;
                min = Math.min(min, temp);
            }
            //왼쪽변
            for(int x = x2; x > x1; x--){
                int next = board[x-1][y1];
                board[x-1][y1] = temp;
                temp = next;
                min = Math.min(min, temp);
            }
            answer[i] = min;
        }

        return answer;
    }
}
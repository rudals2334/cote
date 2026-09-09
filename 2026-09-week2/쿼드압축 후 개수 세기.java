class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        divide(arr, 0, 0, arr.length);
        return answer;
    }
    public void divide(int[][] arr, int x, int y, int size){
        if(isSame(arr, x, y, size)){
            answer[arr[x][y]]++;
            return;
        }
        int half = size / 2;
        divide(arr, x, y, half);
        divide(arr, x, y+half, half);
        divide(arr, x+half, y, half);
        divide(arr, x+half, y+half, half);
    }
    public boolean isSame(int[][] arr, int x, int y, int size){
        int value = arr[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != value){
                    return false;
                }
            }
        }
        return true;
    }
}
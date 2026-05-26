class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int width = 0;
        int length = 0;
        int[] answer = new int[2];
        for(int i = 2; i < total / 2; i++){
            if(total % i != 0){
                continue;
            }
            if(i >= total/i){
                width = i;
                length = total / i;
            }else{
                width = total / i;
                length = i;
            }

            if(tile(width, length, yellow)){
                answer[0] = width;
                answer[1] = length;
                break;
            }
        }
        return answer;
    }
    public boolean tile(int width, int length, int yellow){
        if((width - 2) * (length - 2) == yellow){
            return true;
        }
        return false;
    }
}
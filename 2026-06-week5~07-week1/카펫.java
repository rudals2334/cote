class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for(int i = 1; i <= total / i; i ++){
            if(total % i != 0){
                continue;
            }
            if((i-2) * ((total/i)-2) == yellow){
                if(i >= (total/i)){
                    answer[0] = i;
                    answer[1] = total/i;
                }else{
                    answer[0] = total/i;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }
}
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(true){
            int zero = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    zero++;
                }
            }
            answer[1] += zero;
            int length = s.length() - zero;
            s = Integer.toBinaryString(length);
            answer[0]++;
            if(s.equals("1")){
                break;
            }
        }
        return answer;
    }
}
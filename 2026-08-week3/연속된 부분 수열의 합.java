class Solution {
    public int[] solution(int[] sequence, int k){
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int minLen = Integer.MAX_VALUE;
        int answer_left = 0;
        int answer_right = 0;
        while(left < sequence.length && right < sequence.length){
            if(sum < k){
                if(right == sequence.length-1){
                    break;
                }
                right++;
                sum += sequence[right];
            }else if(sum > k){
                sum -= sequence[left];
                left++;
            }else{
                int len = right - left;
                if(len < minLen){
                    minLen = len;
                    answer_left = left;
                    answer_right = right;
                }
                sum -= sequence[left];
                left++;
            }
        }
        return new int[]{answer_left, answer_right};
    }
}
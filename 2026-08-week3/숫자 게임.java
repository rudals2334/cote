import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int b_p = 0;
        int answer = 0;
        for(int i = 0; i < A.length; i++){
            while(b_p < B.length && B[b_p] <= A[i]){
                b_p++;
            }
            if(b_p == B.length){
                break;
            }
            answer++;
            b_p++;
        }
        return answer;
    }
}
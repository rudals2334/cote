class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        if((sum1 + sum2) % 2 != 0){
            return -1;
        }
        
        long target = (sum1 + sum2) / 2;

        int[] arr = new int[queue1.length + queue2.length];
        for(int i = 0; i < queue1.length; i++){
            arr[i] = queue1[i];
        }
        for(int i = 0; i < queue2.length; i++){
            arr[i+queue1.length] = queue2[i];
        }

        int start = 0;
        int end = queue1.length;
        int answer = 0;
        long sum = sum1;

        while (start != end && end < arr.length) {
            if(sum == target){
                return answer;
            }else if(sum > target){
                sum -= arr[start];
                start++;
                answer++;
            }else{
                sum+=arr[end];
                end++;
                answer++;
            }
        }
        return -1;
    }
}
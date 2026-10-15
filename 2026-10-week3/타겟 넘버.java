class Solution {
    static int answer = 0;

    public  int solution(int[] numbers, int target){
        dfs(numbers,0,0, target);
        return answer;
    }
    
    public static void dfs(int[] numbers, int cnt, int sum, int target){
        if(cnt==numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(numbers, cnt+1, sum+numbers[cnt], target);
        dfs(numbers, cnt+1, sum-numbers[cnt], target);
    }
}
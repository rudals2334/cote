class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] pos = {
                    {3,1}, // 0
                    {0,0}, // 1
                    {0,1}, // 2
                    {0,2}, // 3
                    {1,0}, // 4
                    {1,1}, // 5
                    {1,2}, // 6
                    {2,0}, // 7
                    {2,1}, // 8
                    {2,2}  // 9
                };
        int[] left = {3,0};
        int[] right = {3,2};

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            int[] target = pos[numbers[i]];
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                left = pos[numbers[i]];
                sb.append("L");
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                right = pos[numbers[i]];
                sb.append("R");
            }else{
                int leftDist = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int rightDist = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);
                if(leftDist == rightDist){
                    if(hand.equals("right")){
                        right = target;
                        sb.append("R");
                    }else{
                        left = target;
                        sb.append("L");
                    }
                }else if(leftDist <rightDist){
                    left = target;
                    sb.append("L");
                }else{
                    right = target;
                    sb.append("R");
                }
            }
        }
        String answer = sb.toString();
        return answer;
    }
}
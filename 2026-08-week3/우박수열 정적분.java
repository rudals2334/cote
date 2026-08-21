import java.util.ArrayList;
import java.util.List;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<int[]> list = new ArrayList<>();
        int idx = 0;
        list.add(new int[]{0,k});
        while(k!=1){
            idx++;
            if(k%2==0){
                k /= 2;
            }else{
                k = k * 3 + 1;
            }
            list.add(new int[]{idx,k});
        }
        double[] answer = new double[ranges.length];
        double[] area = new double[idx];
        for(int i = 0; i < idx; i++){
            int under = list.get(i)[1];
            int upper = list.get(i+1)[1];
            area[i] = (under+upper)/2.0;
        }

        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = idx + ranges[i][1];
            if(start > end){
                answer[i] = -1.0;
                continue;
            }else if(start == end){
                answer[i] = 0.0;
                continue;
            }
            for(int j = start; j < end; j++){
                answer[i] += area[j];
            }
        }
        return answer;
    }
}
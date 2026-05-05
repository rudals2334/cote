import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> row = new ArrayList<>();
            int a = arr1[i];
            while(a > 0){
                row.add(a % 2);
                a = a / 2;
            }
            Collections.reverse(row);

            while(row.size() < n){
                row.add(0,0);
            }
            list1.add(row);
        }
        
        
        for(int i = 0; i < n; i++){
            List<Integer> row = new ArrayList<>();
            int a = arr2[i];
            while(a > 0){
                row.add(a % 2);
                a = a / 2;
            }
            Collections.reverse(row);
            while(row.size() < n){
                row.add(0,0);
            }
            list2.add(row);
        }
        
        
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                int a = list1.get(i).get(j);
                int b = list2.get(i).get(j);
                if(a==1 || b==1){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for(int i = 0; i < dirs.length(); i++){
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int x1;
            int y1;
            String a = dirs.substring(i,i+1);

            if(a.equals("U")){
                if(y==5){
                    continue;
                }
                x1 = x;
                y1 = y + 1;

            }else if(a.equals("D")){
                if(y==-5){
                    continue;
                }
                x1 = x;
                y1 = y - 1;

            }else if(a.equals("R")){
                if(x==5){
                    continue;
                }
                x1 = x + 1;
                y1 = y;

            }else{
                if(x==-5){
                    continue;
                }
                x1 = x - 1;
                y1 = y;
            }
            sb.append(x).append(y).append("->").append(x1).append(y1);
            sb2.append(x1).append(y1).append("->").append(x).append(y);
            
            set.add(sb.toString());
            set.add(sb2.toString());
            x = x1;
            y = y1;
        }
        int answer = set.size()/2;
        return answer;
    }
}
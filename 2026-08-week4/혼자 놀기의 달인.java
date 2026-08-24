import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(int[] cards) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < cards.length; i++){
            int cnt = 0;
            if(cards[i] == -1){
                continue;
            }
            cnt++;
            int next = cards[i]-1;
            cards[i] = -1;
            while(cards[next] != -1){
                cnt++;
                int k = next;
                next = cards[next]-1;
                cards[k] = -1;
            }
            list.add(cnt);
        }
        
        list.sort((a,b) -> b-a);
        if(list.size() < 2){
            return 0;
        }
        int answer = list.get(0) * list.get(1);
        return answer;
    }
}
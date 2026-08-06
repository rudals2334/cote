import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> relation = new HashMap<>();
        Map<String, Integer> earn = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            String a = enroll[i];
            String b = referral[i];
            earn.put(a, 0);
            relation.put(a, b);
        }
        for(int i = 0; i < seller.length; i++){
            String a = seller[i];
            int money = amount[i]*100;
            while (!a.equals("-")) {
                int ownMoney = money - (money/10);;
                int shareMoney = money/10;;
                earn.put(a, earn.getOrDefault(a, 0) + ownMoney);

                if(shareMoney == 0){
                    break;
                }
                a = relation.get(a);
                money = shareMoney;
            }
        }
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = earn.get(enroll[i]);
        }
        return answer;
    }
}
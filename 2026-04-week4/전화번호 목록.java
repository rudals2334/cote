import java.util.HashSet;
import java.util.Set;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String num : phone_book){
            set.add(num);
        }
        for(String num : phone_book){
            for(int i = 0; i < num.length(); i++){
                String s = num.substring(0, i);
                if(set.contains(s)){
                    return false;
                }
            }
        }
        return true;
    }
}
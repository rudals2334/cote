import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        int answer = 0;
        for(int i = 0; i < skill.length(); i++){
            String k = skill.substring(i, i+1);
            list.add(k);
            String u = skill.substring(0,i+1);
            list2.add(u);
        }
        for(String tree : skill_trees){
            String a = "";
            for(int i = 0; i < tree.length(); i++){
                if(list.contains(tree.substring(i,i+1))){
                    a = a+tree.substring(i,i+1);
                }
            }
            if(a.equals("") || list2.contains(a)){
                answer++;
            }
        }
        return answer;
    }
}
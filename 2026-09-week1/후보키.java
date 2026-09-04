import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> candidatekeys = new ArrayList<>();
    public int solution(String[][] relation) {
        for(int i = 1; i <= relation[0].length; i++){
            List<Integer> selected = new ArrayList<>();
            dfs(0, 0, i, relation, selected);
        }
        return candidatekeys.size();
    }
    public void dfs(int depth, int start, int target, String[][] relation, List<Integer> selected){
        if(depth == target){
            for(List<Integer> key : candidatekeys){
                if(selected.containsAll(key)){
                    return;
                }
            }

            Set<String> set = new HashSet<>();
            for(int row = 0; row < relation.length; row++){
                StringBuilder sb = new StringBuilder();
                for(int col : selected){
                    sb.append(relation[row][col]).append("|");
                }
                set.add(sb.toString());
            }
            if(set.size() == relation.length){
                candidatekeys.add(new ArrayList<>(selected));
            }
        }

        for(int i = start; i < relation[0].length; i++){
            selected.add(i);
            dfs(depth+1, i+1, target, relation, selected);
            selected.remove(selected.size()-1);
        }
    }
}
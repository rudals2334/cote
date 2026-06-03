import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<int[]> group = new ArrayList<>();
        int totalPick = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPick * 5);

        for(int i = 0; i < minerals.length; i+=5){

            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for(int j = i; j < i+5 && j < maxMinerals; j++){
                if(minerals[j].equals("diamond")){
                    diamond++;
                }else if(minerals[j].equals("iron")){
                    iron++;
                }else{
                    stone++;
                }
            }
            group.add(new int[]{diamond,iron,stone});
        }

        group.sort((a,b) -> {
            if(a[0]!=b[0]){
                return b[0] - a[0];
            }else if(a[1]!=b[1]){
                return b[1] - a[1];
            }
            return b[2] - a[2];
        });
        int answer = 0;

        for(int[] g : group){
            int diamond = g[0];
            int iron = g[1];
            int stone = g[2];

            if(picks[0] > 0){
                answer += diamond + iron + stone;
                picks[0]--;
            }else if(picks[1] > 0){
                answer += diamond*5 + iron + stone;
                picks[1]--;
            }else if(picks[2] > 0){
                answer += diamond*25 + iron*5 + stone;
                picks[2]--;
            }
        }
        return answer;

    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        List<String> genre_list = new ArrayList<>(map.keySet());
        genre_list.sort((a,b) -> map.get(b) - map.get(a));

        List<Integer> answerlist = new ArrayList<>();

        for(String genre : genre_list){
            List<int[]> play_list = new ArrayList<>();
            for(int i = 0; i < plays.length; i++){
                if(genre.equals(genres[i])){
                    play_list.add(new int[]{i,plays[i]});
                }
            }
            play_list.sort((a,b)-> {
                if(a[1]!=b[1]){
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });
            for(int i = 0; i < Math.min(2, play_list.size()); i++){
                answerlist.add(play_list.get(i)[0]);
            }
        }

        int[] answer = new int[answerlist.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerlist.get(i);
        }

        return answer;
    }
}
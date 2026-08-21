import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genre_list = new ArrayList<>(map.keySet());
        genre_list.sort((a,b) -> map.get(b) - map.get(a));

        List<Integer> answerList = new ArrayList<>();

        for(String genre : genre_list){
            List<int[]> playList = new ArrayList<>();
            for(int i = 0; i < plays.length; i++){
                if(genre.equals(genres[i])){
                    playList.add(new int[]{i,plays[i]});
                }
            }
            playList.sort((a,b) -> {
                if(a[1]==b[1]){
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });

            for(int i = 0; i < Math.min(2, playList.size()); i++){
                answerList.add(playList.get(i)[0]);
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
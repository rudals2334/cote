import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();

    public int[] solution(int n, String[] words) {
        map.clear();
        map.put(words[0], 1);

        int[] answer = new int[2];

        for(int i = 1; i < words.length; i++){
            if(!duplication(words[i]) || !wrong(words[i-1], words[i])){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }

        return answer;
    }

    public boolean duplication(String word){
        if(map.containsKey(word)){
            return false;
        }
        map.put(word, 1);
        return true;
    }

    public boolean wrong(String word_one, String word_two){
        int a = word_one.length() - 1;
        return word_one.charAt(a) == word_two.charAt(0);
    }
}
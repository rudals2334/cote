class Solution {
    static int count;
    static int answer;
    String[] arr = {"A","E","I","O","U"};
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    public void dfs(String words, String word){
        if(words.equals(word)){
            answer = count;
            return;
        }
        if(words.length() == 5){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            count++;
            dfs(words + arr[i], word);
        }
    }
}
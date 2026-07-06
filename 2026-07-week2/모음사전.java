class Solution {
    static int answer = 0;
    static int cnt;
    static String[] arr = {"A","E","I","O","U"};
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    public static void dfs(String now, String word){
        if(now.equals(word)){
            answer = cnt;
            return;
        }
        if(now.length() == 5){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            cnt++;
            dfs(now+arr[i], word);
        }
    }
}
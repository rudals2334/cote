class Solution {
    public int solution(int[] players, int m, int k) {
        int[] expire = new int[players.length + k];
        int server = 0;
        int answer = 0;
        for(int i = 0; i < players.length; i++){
            server -= expire[i];
            int need_server = players[i] / m;
            if(server < need_server){
                int add = need_server - server;
                server += add;
                answer += add;

                expire[i+k] += add;
            }
        }
        return answer;
    }
}
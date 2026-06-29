class Solution {
    public int[] solution(String[][] places) {
        int[] dx = {-1, 1, 0, 0, -2, 2, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, 0, 0, -2, 2, -1, 1, -1, 1};

        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++){
            boolean ok = true;
            for(int j = 0; j < places[i].length; j++){
                for(int k = 0; k < 5; k++){
                    if(places[i][j].charAt(k) == 'P'){
                        for(int d = 0; d < 12; d++){
                            int nx = j + dx[d];
                            int ny = k + dy[d];

                            if(!isRange(nx, ny)) continue;

                            if(places[i][nx].charAt(ny) == 'P'){
                                if(d < 4){
                                    ok = false;
                                }else if(d < 8){
                                    int mx = (j + nx) / 2;
                                    int my = (k + ny) / 2;
                                    if(places[i][mx].charAt(my) != 'X'){
                                        ok = false;
                                    }
                                }else{
                                    if(places[i][j].charAt(ny) != 'X' || places[i][nx].charAt(k) != 'X'){
                                        ok = false;
                                    }
                                }
                            }
                            if(!ok) break;
                        }
                    }
                    if(!ok) break;
                }
                if(!ok) break;
            }
            answer[i] = ok ? 1 : 0; 
        }
        return answer;
    }
    public static boolean isRange(int x, int y){
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
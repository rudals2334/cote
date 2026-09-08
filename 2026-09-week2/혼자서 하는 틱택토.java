class Solution {
    public int solution(String[] board) {
        int o_cnt = 0;
        int x_cnt = 0;
        String[][] arr = new String[3][3];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                String k = String.valueOf(board[i].charAt(j));
                arr[i][j] = k;
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j].equals("O")){
                    o_cnt++;
                }else if(arr[i][j].equals("X")){
                    x_cnt++;
                }
            }
        }

        if(!(o_cnt >= x_cnt)||!(x_cnt+1>=o_cnt)){
            return 0;
        }
        if(bingo("O", arr)){
            if(o_cnt != x_cnt+1){
                return 0;
            }
        }
        if(bingo("X", arr)){
            if(x_cnt!=o_cnt){
                return 0;
            }
        }
        return 1;
    }
    public boolean bingo(String s, String[][] arr){
        boolean bing = true;
        //가로
        for(int i = 0; i < arr.length; i++){
            bing = true;
            for(int j = 0; j < arr[i].length; j++){
                if(!arr[i][j].equals(s)){
                    bing = false;
                }
            }
            if(bing){
                return true;
            }
        }
        //세로
        for(int j = 0; j < 3; j++){
            bing = true;
            for(int i = 0; i < 3; i++){
                if(!arr[i][j].equals(s)){
                    bing = false;
                }
            }
            if(bing){
                return true;
            }
        }
        //대각선
        bing = true;
        for(int i = 0; i < 3; i++){
            if(!arr[i][i].equals(s)){
                bing = false;
            }
        }
        if(bing){
            return true;
        }

        bing = true;
        for(int i = 0; i < 3; i++){
            if(!arr[i][2-i].equals(s)){
                bing = false;
            }
        }
        if(bing){
            return true;
        }
        return false;
    }
}
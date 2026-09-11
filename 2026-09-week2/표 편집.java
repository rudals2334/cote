import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<int[]> stack = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];

        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n-1] = -1;
        int cur = k;

        for(String command : cmd){
            char type = command.charAt(0);

            if(type == 'U'){
                int x = Integer.parseInt(command.substring(2));
                for(int i = 0; i < x; i++){
                    cur = prev[cur];
                }
            }   
            
            if(type == 'D'){
                int x = Integer.parseInt(command.substring(2));
                for(int i = 0; i < x; i++){
                    cur = next[cur];
                }
            }

            if(type == 'C'){
                int p = prev[cur];
                int nn = next[cur];

                stack.push(new int[] {p,cur,nn});

                deleted[cur] = true;

                if(p != -1){
                    next[p] = nn;
                }
                if(nn != -1){
                    prev[nn] = p;
                }

                if(nn != -1){
                    cur = nn;
                }else{
                    cur = p;
                }
            }

            if(type == 'Z'){
                int[] recover = stack.pop();
                int p = recover[0];
                int c = recover[1];
                int nn = recover[2];

                deleted[c] = false;

                prev[c] = p;
                next[c] = nn;

                if(p != -1){
                    next[p] = c;
                }
                if(nn != -1){
                    prev[nn] = c;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if (deleted[i]) {
                sb.append("X");
            }else{
                sb.append("O");
            }
        }
        return sb.toString();
    }
}
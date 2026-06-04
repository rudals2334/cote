import java.util.ArrayList;
import java.util.List;

class Solution {
    static String[] express;
    static String[] prior;
    static boolean[] visited;
    static String[] operators = {"+","-","*"};
    static long answer;

    public long solution(String expression) {
        int length = 1;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+'||expression.charAt(i) == '-'||expression.charAt(i) == '*'){
                length++;
            }
        }

        express = new String[length*2-1];
        prior = new String[3];
        visited = new boolean[3];

        int idx = 0;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i)=='*'||expression.charAt(i)=='+'||expression.charAt(i)=='-'){
                express[idx++] = String.valueOf(expression.charAt(i));
            }else{
                StringBuilder sb = new StringBuilder();
                while(i < expression.length() && expression.charAt(i)!='*'&&expression.charAt(i)!='+'&&expression.charAt(i)!='-'){
                    sb.append(String.valueOf(expression.charAt(i)));
                    i++;
                }
                express[idx++] = sb.toString();
                i--;
            }
        }
        dfs(0);
        return answer;
    }

    public void dfs(int depth){
        if(depth == 3){
            List<String> list = new ArrayList<>();
            for(String s : express){
                list.add(s);
            }

            for(String op : prior){
                for(int i = 0; i < list.size(); i++){
                    if (op.equals(list.get(i))) {
                        long left = Long.parseLong(list.get(i-1));
                        long right = Long.parseLong(list.get(i+1));
                        long result = calculate(left, right, op);

                        list.remove(i+1);
                        list.remove(i);
                        list.remove(i-1);

                        list.add(i-1, String.valueOf(result));
                        i--;
                    }
                }
            }
            long result = Math.abs(Long.parseLong(list.get(0)));
            answer = Math.max(answer, result);
            return;
        }

        for(int i = 0; i < operators.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            prior[depth] = operators[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }

    public long calculate(long left, long right, String op){
        if(op.equals("+")){
            return left + right;
        }else if(op.equals("-")){
            return left - right;
        }else{
            return left * right;
        }
    }
}
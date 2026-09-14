import java.util.Stack;
class Solution {
    public String solution(String p) {
        if(p.isEmpty()){
            return "";
        }
        int left = 0;
        int rigjt = 0;

        for(int i = 0; i < p.length(); i++){
            String k = p.substring(i,i+1);
            if(k.equals("(")){
                left++;
            }else{
                rigjt++;
            }

            if(left == rigjt){
                String u = p.substring(0,i+1);
                String v = p.substring(i+1);

                if(isCorrect(u)){
                    return u + solution(v);

                }else{
                    String result = "(";
                    result += solution(v);
                    result += ")";

                    for(int j = 1; j < u.length()-1; j++){
                        String c = u.substring(j,j+1);
                        if(c.equals("(")){
                            result += ")";
                        }else{
                            result += "(";
                        }
                    }
                    return result;
                }

            }
        }
        return "";
    }
    public boolean isCorrect(String u){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < u.length(); i++){
            String k = u.substring(i,i+1);
            if(k.equals("(")){
                stack.add(k);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                    
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
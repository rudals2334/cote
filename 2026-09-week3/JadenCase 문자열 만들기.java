class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == ' '){
                first = true;
            }else{
                if(first){
                    c = Character.toUpperCase(c);
                    first = false;
                }else{
                    c = Character.toLowerCase(c);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
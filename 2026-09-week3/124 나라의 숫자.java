class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int a = n / 3;
            int b = n % 3;
            if(b==0){
                b = 4;
                a--;
            }
            n = a;
            sb.append(b);
        }
        String t = sb.toString();
        sb = new StringBuilder();
        for(int i = t.length()-1; i >= 0; i--){
            char c = t.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }
}
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int len = 1; len <= s.length()/2; len++){
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            String prev = "";
            int i;
            for(i = 0; i <= s.length() - len; i+=len){
                String str = s.substring(i,i+len);

                if(i == 0){
                    prev = str;
                    continue;
                }
                if(prev.equals(str)){
                    cnt++;
                }else{
                    if(cnt > 1){
                        sb.append(cnt).append(prev);
                    }else{
                        sb.append(prev);
                    }
                    cnt = 1;
                    prev = str;
                }
            }

            if(cnt > 1){
                sb.append(cnt).append(prev);
            }else{
                sb.append(prev);
            }

            if(i < s.length()){
                sb.append(s.substring(i));
            }

            answer = Math.min(answer, sb.length());

        }
        return answer;
    }
}
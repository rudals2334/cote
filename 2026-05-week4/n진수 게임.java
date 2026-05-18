class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; sb.length() < t * m; i++){
            int num = i;
            if(num == 0){
                sb.append(0);
            }else{
                StringBuilder temp = new StringBuilder();
                temp.append(Integer.toString(num,n).toUpperCase());
                sb.append(temp);
            }
        }

        String a = sb.toString();
        String[] arr = new String[t];
        int idx = 0;
        for(int i = p-1; idx < t; i += m){
            arr[idx] = String.valueOf(a.charAt(i));
            idx++;
        }
        answer = String.join("", arr);
        return answer;
    }
}
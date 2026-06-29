class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; sb.length() <= m * t; i++){
                sb.append(Integer.toString(i,n).toUpperCase());  
        }
        int idx = 0;
        String answer = "";
        String[] arr = new String[t];
        for(int i = p-1; idx < t; i+=m){
            arr[idx] = String.valueOf(sb.charAt(i));
            idx++;
        }
        answer = String.join("", arr);
        return answer;
    }
}
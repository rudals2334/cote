import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            String a = record[i].split(" ")[0];
            if(a.equals("Enter") || a.equals("Change")){
                user.put(record[i].split(" ")[1], record[i].split(" ")[2]);
            }
        }
        int len = 0;
        for(int i = 0; i < record.length; i++){
            String a = record[i].split(" ")[0];
            if(a.equals("Enter") || a.equals("Leave")){
                len++;
            }
        }
        String[] answer = new String[len];
        int k = 0;
        for(int i = 0; i < record.length; i++){
            String a = record[i].split(" ")[0];
            if(a.equals("Enter")){
                answer[k] = user.get(record[i].split(" ")[1]) + "님이 들어왔습니다.";
                k++;
            }else if(a.equals("Leave")){
                answer[k] = user.get(record[i].split(" ")[1]) + "님이 나갔습니다.";
                k++;
            }
        }
        return answer;
    }
}
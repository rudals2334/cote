import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int len = 0;
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            String command = arr[0];
            String id = arr[1];
            if(command.equals("Enter")){
                String name = arr[2];
                map.put(id, name);
                len++;
            }else if(command.equals("Change")){
                String name = arr[2];
                map.put(id, name);
            }else{
                len++;
            }
        }

        String[] answer = new String[len];
        int idx = 0;
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            String command = arr[0];
            String id = arr[1];
            String name = map.get(id);
            if(command.equals("Enter")){
                answer[idx] = name + "님이 들어왔습니다.";
                idx++;
            }else if(command.equals("Leave")){
                answer[idx] = name + "님이 나갔습니다.";
                idx++;
            }
        }
        return answer;
    }
}
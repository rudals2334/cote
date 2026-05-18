class Solution {
    public String solution(String m, String[] musicinfos) {
        m = change(m);
        String answer = "(None)";
        int maxLen = -1;
        for(int i = 0; i < musicinfos.length; i++){
            String[] music = musicinfos[i].split(",");
            int end = Integer.parseInt(music[1].split(":")[0]) * 60 + Integer.parseInt(music[1].split(":")[1]);
            int start = Integer.parseInt(music[0].split(":")[0]) * 60 + Integer.parseInt(music[0].split(":")[1]);
            int len = end - start;
            String melody = change(music[3]);

            String[] lylic = new String[len];

            for(int j = 0; j < len; j++){
                lylic[j] = String.valueOf(melody.charAt(j % melody.length()));
            }
            
            String str = String.join("", lylic);
            if(str.contains(m)){
                if(len > maxLen){
                    answer = music[2];
                    maxLen = len;
                }
            }
        }
        return answer;
    }
    public String change(String s){
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");        
    }
}
import java.util.Arrays;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files,(a,b) -> {
            // a의 head부분
            int idxA = 0;
            while (idxA < a.length() && !Character.isDigit(a.charAt(idxA))) {
                idxA++;
            }
            String headA = a.substring(0, idxA);
            // a의 number부분
            int startA = idxA;
            while(idxA < a.length() && Character.isDigit(a.charAt(idxA))){
                idxA++;
            }
            String NumA = a.substring(startA,idxA);

            // b의 head부분
            int idxB = 0;
            while (idxB < b.length() && !Character.isDigit(b.charAt(idxB))) {
                idxB++;
            }
            String headB = b.substring(0, idxB);
            // b의 number부분
            int startB = idxB;
            while(idxB < b.length() && Character.isDigit(b.charAt(idxB))){
                idxB++;
            }
            String NumB = b.substring(startB,idxB);

            //정렬
            int cmp = headA.toLowerCase().compareTo(headB.toLowerCase());
            if(cmp != 0){
                return cmp;
            }
            int numA = Integer.parseInt(NumA);
            int numB = Integer.parseInt(NumB);
            return numA - numB;
        });
        return files;
    }
}
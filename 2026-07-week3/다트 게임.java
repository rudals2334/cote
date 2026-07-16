class Solution {
    public int solution(String dartResult) {
        int[] arr = new int[3];
        int index = 0;
        for(int i = 0; i < dartResult.length()-1; i++){
            String a = String.valueOf(dartResult.charAt(i));
            char b = dartResult.charAt(i);
            if(Character.isDigit(b)){
                if(b == '1' && dartResult.charAt(i+1) == '0'){
                    a += "0";
                    i++;
                }
                int k = Integer.parseInt(a);
                arr[index] = k;
                index++;
            }
        }
        index = 0;
        for(int i = 0; i < dartResult.length(); i++){
            char a = dartResult.charAt(i);
            if(a == 'S'){
                arr[index] = (int)Math.pow(arr[index], 1);
                index++;
            }else if(a == 'D'){
                arr[index] = (int)Math.pow(arr[index], 2);
                index++;
            }else if(a == 'T'){
                arr[index] = (int)Math.pow(arr[index], 3);
                index++;
            }else if(a == '*'){
                arr[index-1] *= 2;
                if(index>=2){
                    arr[index-2] *= 2;
                }
            }else if(a== '#'){
                arr[index-1] *= (-1);
            }
        }

        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }
        return answer;
    }
}
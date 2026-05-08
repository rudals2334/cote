class Solution {
    public int solution(String dartResult) {
        int total = 0;
        int len = 0;
        for(int i = 0; i < dartResult.length(); i++){
            String a = dartResult.substring(i,i+1);
            if(a.equals("S") || a.equals("D") || a.equals("T")){
                len++;
            }
        }
        int[] arr = new int[len];
        int index = 0;
        for(int i = 0; i < dartResult.length(); i++){
            String a = dartResult.substring(i,i+1);
            if(a.equals("S") || a.equals("D") || a.equals("T")){
                if(a.equals("S")){
                    arr[index]=(int)Math.pow(arr[index], 1);
                }else if(a.equals("D")){
                    arr[index]=(int)Math.pow(arr[index], 2);
                }else{
                    arr[index]=(int)Math.pow(arr[index], 3);
                }
                index++;
            }else if(a.equals("*") || a.equals("#")){
                if(a.equals("*")){
                    if(index > 1){
                        arr[index-1] *= 2;
                        arr[index-2] *= 2;
                    }else{
                        arr[index-1] *= 2;
                    }
                }else{
                    arr[index-1] *= (-1);
                }
            }else{
                int num = dartResult.charAt(i) - '0';
                if(num==1 && dartResult.charAt(i+1)-'0' == 0){
                    num = 10;
                    i++;
                }
                arr[index] = num;
            }
        }
        
        for(int s : arr){
            System.out.println(s);
            total += s;
        }
        return total;
    }
}
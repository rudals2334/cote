class Solution {
    static int[] discount = {10,20,30,40};
    static int[] selected;
    static int maxSubscriber = 0;
    static int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        selected = new int[emoticons.length];
        dfs(0, users, emoticons);
        int[] answer = new int[2];
        answer[0] = maxSubscriber;
        answer[1] = maxSales;        
        return answer;
    }

    public void dfs(int x, int[][] users, int[] emoticons){
        if(x == emoticons.length){
            int subscriber = 0;
            int sales = 0;

            for(int[] user : users){
                int minDiscount = user[0];
                int limit = user[1];
                int sum = 0;
                for(int i = 0; i < emoticons.length; i++){
                    if(selected[i] >= minDiscount){
                        sum += emoticons[i] * (100 - selected[i]) / 100;
                    }
                }

                if(sum >= limit){
                    subscriber++;
                }else{
                    sales += sum;
                }    
            }

            if(subscriber > maxSubscriber){
                maxSubscriber = subscriber;
                maxSales = sales;
            }else if(subscriber == maxSubscriber){
                maxSales = Math.max(sales, maxSales);
            }
            return;
        }

        for(int d : discount){
            selected[x] = d;
            dfs(x+1, users, emoticons);
        }
    }
}
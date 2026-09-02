class Solution {
    static int[] discount = {10,20,30,40};
    static int[] selected;
    static int maxSub;
    static int maxSales;
    public int[] solution(int[][] users, int[] emoticons) {
        selected = new int[emoticons.length];
        dfs(0, users, emoticons);
        return new int[]{maxSub, maxSales};
    }
    public void dfs(int x, int[][] users, int[] emoticons){
        if(x == emoticons.length){
            int subscriber = 0;
            int sales = 0;
            for(int[] user : users){
                int minDis = user[0];
                int limit = user[1];
                int sum = 0;
                for(int i = 0; i < emoticons.length; i++){
                    if(selected[i] >= minDis){
                        sum += emoticons[i] * (100 - selected[i]) / 100;
                    }
                }

                if(sum >= limit){
                    subscriber++;
                }else{
                    sales += sum;
                }
            }
            if(subscriber > maxSub){
                maxSub = subscriber;
                maxSales = sales;
            }else if(subscriber == maxSub){
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
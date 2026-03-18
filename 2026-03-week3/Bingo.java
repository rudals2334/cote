import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bingo {
// 문제
// 빙고 게임은 다음과 같은 방식으로 이루어진다.
// 먼저 아래와 같이 25개의 칸으로 이루어진 빙고판에 1부터 25까지 자연수를 한 칸에 하나씩 쓴다.
// 차례로 수를 지워가다가 같은 가로줄, 세로줄 또는 대각선 위에 있는 5개의 모든 수가 지워지는 경우 그 줄에 선을 긋는다.
// 이러한 선이 세 개 이상 그어지는 순간 "빙고"라고 외치는데, 가장 먼저 외치는 사람이 게임의 승자가 된다.
// 철수는 친구들과 빙고 게임을 하고 있다. 철수가 빙고판에 쓴 수들과 사회자가 부르는 수의 순서가 주어질 때, 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄부터 다섯째 줄까지 빙고판에 쓰여진 수가 가장 위 가로줄부터 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 
// 여섯째 줄부터 열째 줄까지 사회자가 부르는 수가 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 
// 빙고판에 쓰여진 수와 사회자가 부르는 수는 각각 1부터 25까지의 수가 한 번씩 사용된다.    

// 출력
// 첫째 줄에 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지 출력한다.
        public static void main(String[] args)throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean[][] booleans = new boolean[5][5];
            int[][] bingo = new int[5][5];
            int[][] check = new int[5][5];
            int cnt = 0;

            for(int i = 0; i < 5; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 5; j++){
                    bingo[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 5; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 5; j++){
                    check[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    int num = check[i][j];
                    cnt++;
                    for(int k = 0; k < 5; k++){
                        for(int l = 0; l < 5; l++){
                            if(num == bingo[k][l]){
                                booleans[k][l]=true;
                                if(BING(booleans)>=3){
                                    System.out.println(cnt);
                                    return;
                                    }
                                }
                            }
                            
                        }
                    }
                }
            }
        
        public static int BING(boolean[][] booleans){
            int line = 0;

            for(int i = 0; i < 5; i++){ //가로줄 판단
                boolean ok = true;
                for(int j = 0; j < 5; j++){
                    if(!booleans[i][j]){
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    line++;
                }  
            }
            for(int j = 0; j < 5; j++){ //세로줄 판단
                boolean ok = true;
                for(int i = 0; i < 5; i++){
                    if(!booleans[i][j]){
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    line++;
                }  
            }
            //대각선 판단
            boolean ok = true;
            for(int i = 0; i < 5; i++){
                if(!booleans[i][i]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                line++;
            }
            ok = true;
            for(int i = 0; i < 5; i++){
                if(!booleans[i][4-i]){
                    ok = false;
                    break;
                }
            }
            if(ok) line++;
            return line;
        }
}


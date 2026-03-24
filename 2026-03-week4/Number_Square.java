import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number_Square {
// 문제
// N×M크기의 직사각형이 있다. 각 칸에는 한 자리 숫자가 적혀 있다. 이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오. 
// 이때, 정사각형은 행 또는 열에 평행해야 한다.

// 입력
// 첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.

// 출력
// 첫째 줄에 정답 정사각형의 크기를 출력한다.
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] square = new char[n][m];

        for(int i = 0; i < n; i++){
            String num_square = br.readLine();
            for(int j = 0; j < m; j++){
                square[i][j] = num_square.charAt(j);
            }
        }

        int max = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char vertex = square[i][j];
                for(int k = 0; k < Math.min(n, m); k++){
                    if(i+k < n && j+k < m && square[i+k][j+k] == vertex && square[i+k][j] == vertex && square[i][j+k] == vertex){
                        if(k+1>max){
                            max = k+1;
                        }
                    }
                }
            }
        }
        System.out.println(max*max);
        
        
    }
}

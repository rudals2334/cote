import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_of_GCD {
// 문제
// 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다. 각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1,000,000을 넘지 않는다.

// 출력
// 각 테스트 케이스마다 가능한 모든 쌍의 GCD의 합을 출력한다.   
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            long sum = 0;
            for(int j = 0; j < n; j++){
                int k = Integer.parseInt(st.nextToken());
                arr[j] = k;
            }
            for(int m = 0; m < n-1; m++){
                for(int l = m+1; l < n; l++){
                    if(arr[m]>arr[l]){
                        sum += GCD(arr[m],arr[l]);
                    }else{
                        sum += GCD(arr[l],arr[m]);
                    }
                }
            }
            System.out.println(sum);
        }
        
    }
    public static Integer GCD(int a, int b){ //유클리드 호제법
        int r = 0;
        while(true){
            r = a%b;
            if(r==0){
                return b;
            }
            a=b;
            b=r;
        }
        
    }
}

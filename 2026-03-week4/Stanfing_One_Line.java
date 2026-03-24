import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stanfing_One_Line {
// 문제
// N명의 사람들은 매일 아침 한 줄로 선다. 이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.
// 어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다. 그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.
// 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다. N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.
// 각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 사람의 수 N이 주어진다. N은 10보다 작거나 같은 자연수이다. 둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다. i번째 수는 0보다 크거나 같고, N-i보다 작거나 같다. i는 0부터 시작한다.

// 출력
// 첫째 줄에 줄을 선 순서대로 키를 출력한다.    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n];
        int[] sequence = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            line[i] = Integer.parseInt(st.nextToken());
        }

        ///////////////List를 쓰는 첫번째 방법(키가 큰 사람부터 배치)///////////////
        List<Integer> list = new ArrayList<>();
        for(int i = n-1; i >= 0; i--){
            list.add(line[i], i+1);  //list.add(index, value) index 위치에 value값 끼워넣기, 기존 값은 뒤로 밀림
        }
        
        for(int num : list){
            System.out.print(num + " ");
        }

        System.out.println();

        ///////////////다른 배열을 쓰는 두번째 방법(키가 작은 사람부터 배치)///////////////
        for(int i = 0; i < n; i++){
            int a = line[i];
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(sequence[j] == 0){
                    if(cnt==a){
                        sequence[j] = i+1;
                        break;
                    }
                    cnt++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(sequence[i] + " ");
        }
        
    }
}

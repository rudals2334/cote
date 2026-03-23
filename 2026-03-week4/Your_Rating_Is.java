import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Your_Rating_Is {
// 문제
// 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
// 치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
// 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
// 인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
// A+	4.5     // A0	4.0
// B+	3.5     // B0	3.0
// C+	2.5     // C0	2.0
// D+	1.5     // D0	1.0
// F	0.0     // P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
// 과연 치훈이는 무사히 졸업할 수 있을까?

// 입력
// 20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.

// 출력
// 치훈이의 전공평점을 출력한다.

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] name = new String[20];
        double[] credit = new double[20];
        String[] rating = new String[20];
        double[] rating_double = new double[20];

        for(int i = 0; i < 20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            credit[i] = Double.parseDouble(st.nextToken());
            rating[i] = st.nextToken();
        }

        for(int i = 0; i < 20; i++){
            if(rating[i].equals("A+")){
                rating_double[i] = 4.5;
            }else if (rating[i].equals("A0")) {
                rating_double[i] = 4.0;
            }else if (rating[i].equals("B+")) {
                rating_double[i] = 3.5;
            }else if (rating[i].equals("B0")) {
                rating_double[i] = 3.0;
            }else if (rating[i].equals("C+")) {
                rating_double[i] = 2.5;
            }else if (rating[i].equals("C0")) {
                rating_double[i] = 2.0;
            }else if (rating[i].equals("D+")) {
                rating_double[i] = 1.5;
            }else if (rating[i].equals("D0")) {
                rating_double[i] = 1.0;
            }else if (rating[i].equals("F")) {
                rating_double[i] = 0.0;
            }else if (rating[i].equals("P")) {
                rating_double[i] = 0.0;
            }
        }        

        double sum = 0.0;
        double cnt = 0.0;
        for(int i = 0; i < 20; i++){
            if(rating[i].equals("P")) {
                continue;
            }
            cnt += credit[i];
            double a = (rating_double[i] * credit[i]);
            sum+=a;
        }
        System.out.println(sum/cnt);


    }
}

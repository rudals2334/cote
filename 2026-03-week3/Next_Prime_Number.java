import java.util.Scanner;

public class Next_Prime_Number {
// 문제
// 정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.

// 출력
// 각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            long n = sc.nextLong();

            while(!isPrime(n)){
                n++;
            }
        System.out.println(n);

        }
    }
    public static boolean isPrime(long A){
        if(A<2){
            return false;
        }
        for(long i = 2; i * i <=A; i++){ //√A 보다 작은 수로 나누어지면 소수가 아님!!
            if(A%i==0){
                return false;
            }
        }
        return true;
    }
}

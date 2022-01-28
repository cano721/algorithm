import java.util.Scanner;

public class Test {

    public static boolean[] prime; // 소수판별 저장 배열
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        solve(num);
        // 해당 숫자이하에 모든 소수를 구할때
        for(int i = 0; i <= num; i++){
            if(prime[i] == false){
                System.out.printf("%d는 소수\n",i);
            }else{
                System.out.printf("%d는 소수아님\n",i);
            }
        }
    }

    public static void solve(int num){
        // 0~num까지 true면 소수가 아님
        prime = new boolean[num+1];
        
        // 0 또는 1은 소수가 아님
        if(num < 2) return;
        
        // 0과 1은 소수가 아님
        prime[0] = prime[1] = true;


        // 그외의 수(루트이하의 수로 나눠보기)
        for(int i = 2; i <= Math.sqrt(num); i++){

            // 이미 확인된거면 패스
            if(prime[i] == true){
                continue;
            }

            // 배수부터 시작하여 다음배수만큼 증가
            for(int j = i*i; j < prime.length; j = j+i){
                // 소수아닌걸로 처리
                prime[j] = true;
            }
            
        }
    }
}

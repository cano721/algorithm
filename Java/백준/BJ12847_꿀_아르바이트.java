/**
 * 최대 수익 벌기
 *
 * m일 밖에 일을 할 수 없음.
 *
 * m이라는 슬라이딩 윈도우를 가지고 최대치 계산하기. O(N)
 *
 * 정답 범위가 int 초과한다는 걸 파악 필요
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        long[] payList = new long[N];

        for(int i = 0; i < N; i++) {
            payList[i] = scanner.nextInt();
        }

        int start = 0;
        long max = 0, sum = 0;

        for(int day = 0; day < N; day++){
            sum += payList[day];
            if(day-start+1 > M){ // index가 0부터 시작하므로 -1을 해줌
                sum -= payList[start];
                start++;
            }
            max = Math.max(max,sum);
        }

        System.out.println(max);
    }
}
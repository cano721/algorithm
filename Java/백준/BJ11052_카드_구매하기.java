/**
 * 카드팩 마다 1개당의 단가 측정
 *
 * 제일 비싼 카드 팩으로 일정 팩을 산 후 나머지 카드의 숫자를 맞추기
 *
 * 카드 n장을 구매하는 가장 비싼 값을 dp 풀이로 하기
 *
 * dp[i] = i장팩으로 초기화
 *
 * dp[0] = 0;
 * dp[1] = 1장팩
 * dp[2] = Math.max(dp[1]+dp[1],dp[2])
 * dp[3] = Math.max(dp[2]+dp[1],dp[3])
 * dp[4] = Math.max(dp[3]+dp[1],dp[2] + dp[2],dp[4])
 * dp[5] = Math.max(dp[4]+dp[1],dp[3]+dp[2],dp[5])
 * dp[6] = Math.max(dp[5]+dp[1],dp[4]+dp[2],dp[3] + dp[3], dp[6])
 * dp[n] = Math.max(dp[n-1]+dp[1],dp[n-2]+dp[2],dp[n-3]+dp[3],...,dp[1]+dp[n-1],dp[n])
 *
 * 시간복잡도 = N(N+1)/2 = O(N^2) N의 최대값은 1000
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int N = scanner.nextInt();
        int[] array = new int[N+1];

        for (int i = 0; i < N; i++) {
            int P = scanner.nextInt();
            array[i+1] = P;
        }

        long[] dp = getDp(N, array);

        System.out.println(dp[N]);
    }

    private static long[] getDp(int N, int[] array) {
        long[] dp = new long[N +1];

        for(int i = 1; i <= N; i++){
            dp[i] = array[i];
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i],dp[i-j]+dp[j]);
            }
        }
        return dp;
    }
}
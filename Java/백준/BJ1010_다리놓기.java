/**
 * 테스트 케이스 개수 T
 *
 * 동쪽 사이트 개수 중에 서쪽 사이트 개수만큼 선택하여 이어주기
 * 즉, 조합공식 nCr
 *
 * 파스칼 법칙에 따라 nCr = n-1Cr-1 + n-1Cr
 * 해당 공식을 이용하여 DP로 풀이
 *
 * 시간복잡도 : O(T)
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            long answer = dp(N, M);

            System.out.println(answer);
        }
    }

    private static long dp(int n, int m) {
        long[][] dp = new long[m+1][n+1];

        for(int i = 0; i<= m;i++){
            for(int j = 0; j <= Math.min(i,n); j++){
                if(j == 0 || i==j){
                    dp[i][j] = 1;
                } else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
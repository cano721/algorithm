/**
 * 구현
 * 
 * dp[1] = 1   1 = 1^2
 * dp[2] = 2   2 = 1^2 +1^2
 * dp[3] = 3   3 = 1^2 +1^2 +1^2
 * dp[4] = 1   4 = 2^2
 * dp[5] = dp[2^2] +dp[1]   5 = 2^2 + 1^2
 * dp[6] = dp[2^2] +dp[2] 6 = 2^2 +1^2 +1^2
 * 
 * j*j가 i보다 작은 수라는 가정하에
 * dp[i] = dp[i - j*j] +dp[j*j];
 * 제곱수는 다 1임 dp[j*j] == 1
 */

import java.util.*;
import java.io.*;

public class BJ17626_FourSquares {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(i == 1) dp[1] = 1;
            else{
                int minCnt = Integer.MAX_VALUE;
                for(int j = 1; j*j <= i; j++){
                    minCnt = Math.min(dp[i-j*j],minCnt);
                }
                dp[i] = minCnt +1;
            }
        }

        System.out.println(dp[n]);
    }
}

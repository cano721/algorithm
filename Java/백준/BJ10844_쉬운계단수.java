/*
   2차원 dp로 생성
   dp[자리수][숫자] = 개수

   0은 1에서만 올 수 있음
   9는 8에서만 올 수 있음
   나머지는 양 옆에서 올 수 있음
   ex) 1 - > 0,2   3 -> 2,4

   0 1 2 3 4 5 6 7 8 9
 0 0 0 0 0 0 0 0 0 0 0
 1 0 1 1 1 1 1 1 1 1 1
 2 1 1 2 2 2 2 2 2 2 1
 3 1 2 3 4 4 4 4 4 3 2
 4 2 4 6 7 8 8 8 7 6 3

 이를 바탕으로 점화식 생성
*/

import java.util.*;
import java.io.*;

public class BJ10844_쉬운계단수 {

    public static Long[][] dp = new Long[101][10];
    public static long mod = 1_000_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 초기 dp 채우기
        Arrays.fill(dp[1],1l);
        dp[1][0] = 0l;
        // for(int i = 0; i < 10; i++){
        //     topdown(n,i);
        // }
        bottomUp(n);
        long sum = 0l;
        for(long v: dp[n]){
            sum+= v%mod;
        }
        bw.write(sum%mod + "\n");
        bw.flush();
        bw.close();
    }

    //탑다운방식
    public static long topdown(int n,int m){
        if(
         n == 1){
            return dp[n][m];
        }
        if(dp[n][m] == null){
            if(m == 0){
                dp[n][m] = topdown(n-1,1);
            }else if(m == 9){
                dp[n][m] = topdown(n-1,8);
            }else{
                dp[n][m] = topdown(n-1,m-1) + topdown(n-1,m+1);
            }
        }
        return dp[n][m]%mod;
    }

    // 바텀업방식
    public static void bottomUp(int n){
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0){
                    dp[i][0] = dp[i-1][1] % mod;
                }else if(j == 9){
                    dp[i][j] = dp[i-1][8] % mod;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
                }
            }
        }
    }
}

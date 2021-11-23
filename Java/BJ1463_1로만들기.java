/*
   
*/

import java.util.*;
import java.io.*;

public class BJ1463_1로만들기 {

    public static int[] dp;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        topdown(n, 0);
        // answer = bottomUp(n);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    //탑다운방식
    public static void topdown(int n,int cnt){
        if(n <= 1){
            answer = Math.min(answer,cnt);
            return;
        }

        if(cnt >= answer) return;

        if(n %3 == 0) topdown(n/3,cnt+1);
        if(n %2 == 0) topdown(n/2,cnt+1);
        topdown(n-1,cnt+1);
    }
    // 바텀업방식
    public static int bottomUp(int n){
        
        // 1 = 0에서 10으로 반대로 올라갈것!
        for(int i = 2; i <= n; i++){
            // 3번연산인 1을 뺀다
            dp[i] = dp[i-1] + 1;

            // 1번연산 x%3으로 떨어지면 3으로 나누기
            if(i % 3 == 0) dp[i] = Math.min(dp[i],dp[i/3] + 1);

            // 2번연산 x%2로 떨어지면 2로 나누기
            if(i % 2 == 0) dp[i] = Math.min(dp[i],dp[i/2] + 1);
        }

        return dp[n];

    }
}

/*
    n= 1 : 1
    n= 2 : 1
    n= 3 : 1
    n= 4 : 2
    n= 5 : 2
    n= 6 : 3
    n= 7 : 4
    n= 8 : 5
    n= 9 : 7
    n=10 : 9

    위의 숫자를 볼때 찾아낼 수 있는 점화식은
    dp[n] = dp[n-2] + dp[n-3]

    해당 점화식으로 탑다운,바텀업 풀이
    
*/

import java.util.*;
import java.io.*;

public class BJ9461_파도반수열 {

    public static Long[] dp = new Long[1_000_001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine());
            Long num = bottomUp(n);
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    //탑다운방식
    public static long topdown(int n){
        // 이미 구한적이 있다면 구한것을 반환
        if(dp[n] != null){
            return dp[n];
        }
        // n 이 1,2일땐 반환 그 외엔
        // 점화식을 통한 값 저장 및 반환
        if(n == 1 || n == 2 || n == 3) return 1;
        else{
            dp[n] = topdown(n-2) + topdown(n-3);
            return dp[n];
        }
    }

    //바텀업방식
    public static long bottomUp(int n){
        if(n == 1 || n == 2 || n == 3) return 1;

        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}

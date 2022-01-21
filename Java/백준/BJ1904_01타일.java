/*
    n= 1 : 1
    n= 2 : 00 11
    n= 3 : 100 001 111
    n= 4 : 0000 1100 1001 0011 1111
    n= 5 : 10000 00001 11100 11001 10011 00111 00100 11111

    위를 보면 알 수 있는것은
    dp[n] = dp[n-1] + dp[n-2] 를 알 수 있다.

    이 점화식을 바탕으로 바텀업과 탑다운을 할것.
    
    
*/

import java.util.*;
import java.io.*;

public class BJ1904_01타일 {

    public static Integer[] dp = new Integer[1_000_001];
    public static int divNum = 15746;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = bottomUp(n);
        bw.write(num + "\n");
        bw.flush();
        bw.close();
    }

    //탑다운방식
    public static int topdown(int n){
        // 이미 구한적이 있다면 구한것을 반환
        if(dp[n] != null){
            return dp[n];
        }
        // n 이 1,2일땐 반환 그 외엔
        // 점화식을 통한 값 저장 및 반환
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else{
            dp[n] = (topdown(n-1) + topdown(n-2)) % divNum;
            return dp[n] % divNum;
        }
    }

    //바텀업방식
    public static int bottomUp(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % divNum;
        }
        return dp[n] % divNum;
    }
}

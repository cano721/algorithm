/*
   인접한 집과 색이 달라야함.

   이를 토대로 점화식 생성
   2차원 dp 생성할 예정

   현재 초록색을 골랐다면
   바로 전 초록색을 고르지않은 최소값에서 현재 초록색값을 더한걸 dp에 저장

   
   dp[n][0] = Math.min(dp[n-1][1],dp[n-1][2])+arr[n]][0]
   
   이런형태로 최종 dp[n] 까지와서
   dp[n][0],dp[n][1],dp[n][2] 중 최소값 출력
    
*/

import java.util.*;
import java.io.*;

public class BJ1149_RGB거리 {

    public static Long[][] dp = new Long[1001][3];
    public static Long[][] arr = new Long[1001][3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 넣기
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }


        // 초기값 넣기
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        bottomUp(n);
        // 3개 비교
        long answer = Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }

    //탑다운방식
    public static Long[] topdown(int n){
        // 이미 구한적이 있다면 구한것을 반환
        if(dp[n][0] != null && dp[n][1] != null && dp[n][2] != null){
            return dp[n];
        }
        dp[n][0] = Math.min(topdown(n-1)[1],topdown(n-1)[2]) + arr[n][0];
        dp[n][1] = Math.min(topdown(n-1)[0],topdown(n-1)[2]) + arr[n][1];
        dp[n][2] = Math.min(topdown(n-1)[0],topdown(n-1)[1]) + arr[n][2];

        return dp[n];
    }

    //바텀업방식
    public static void bottomUp(int n){
        for(int i = 2; i <= n; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
        }
    }
}

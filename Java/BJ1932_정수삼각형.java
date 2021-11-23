/*
   2차원 dp

   왼쪽 끝은 왼쪽끝에서 밖에 안옴
   오른쪽 끝은 오른쪽 끝에서 밖에 안옴

   양쪽에서 오는 경우는 저 두가지 조건을 제외한 경우
    if(j == 0){
        dp[i][j] = dp[i-1][j] + arr[i][j];
    }else if(j == i-1){
        dp[i][j] = dp[i-1][j-1] + arr[i][j];
    }else{
        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j+1]) + arr[i][j];
    }


    1

    23

    343556

    3453456
    
*/

import java.util.*;
import java.io.*;

public class BJ1932_정수삼각형 {

    public static Long[][] dp = new Long[501][501];
    public static Long[][] arr = new Long[501][501];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 넣기
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }


        // 초기값 넣기
        dp[1][0] = arr[1][0];
        bottomUp(n);
        // 마지막 값 중 최대값 출력
        long answer = 0;
        for(int i = 0; i < n; i++){
            answer = Math.max(answer,dp[n][i]);
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    //탑다운방식
    public static Long[] topdown(int n){
        // 이미 구한적이 있다면 구한것을 반환
        if(dp[n][0] != null){
            return dp[n];
        }
        for(int j = 0; j < n; j++){
            // 왼쪽 끝인경우
            if(j == 0){
                dp[n][j] = topdown(n-1)[j] + arr[n][j];
            // 오른쪽 끝
            }else if(j == n-1){
                dp[n][j] = topdown(n-1)[j-1] + arr[n][j];
            // 양쪽에서 올 수 있는 경우
            }else{
                dp[n][j] = Math.max(dp[n-1][j-1],dp[n-1][j]) + arr[n][j];
            }
        }
        return dp[n];
    }

    //바텀업방식
    public static void bottomUp(int n){
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                // 왼쪽 끝인경우
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                // 오른쪽 끝
                }else if(j == i-1){
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                // 양쪽에서 올 수 있는 경우
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                }
            }
        }
    }
}

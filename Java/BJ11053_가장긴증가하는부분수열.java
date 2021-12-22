/*
   LIS로 가장 긴 증가하는 부분 수열 찾기

   dp[배열] = 부분수열 길이

*/

import java.util.*;
import java.io.*;

public class BJ11053_가장긴증가하는부분수열 {

    public static int[] dp;
    public static int[] arr;
    public static int n,max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dp = new int[n];
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bottomUp();
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    

    // 바텀업방식
    public static void bottomUp(){
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < n; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    max = Math.max(dp[i],max);
                }
            }
        }
    }
}
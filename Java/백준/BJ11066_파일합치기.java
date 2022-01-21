import java.io.*;
import java.util.*;

// 실패

public class BJ11066_파일합치기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k+1];
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= k; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                sum[j] = sum[j-1]+num;
            }

            
            // 몇장 묶을건지
            for(int end = 1; end <= k; end++){
                // 시작지점()
                for(int from= 1; from + end <= k; from++){
                    // 최대 갈 수 있는 지점
                    int to = from +end;
                    // 맥스값으로 초기설정
                    dp[from][to] = Integer.MAX_VALUE;
                    // 나눠서 더해보기(1~n 일때 1~3 4~n 이런식으로 나누기)
                    for(int divide = from; divide < to; divide++){
                        dp[from][to] = Math.min(dp[from][to],dp[from][divide] + dp[divide+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }
            bw.write(dp[1][k] +"\n");
        }
        bw.flush();
        bw.close();
    }


}

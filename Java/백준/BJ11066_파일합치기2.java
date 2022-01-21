import java.io.*;
import java.util.*;

// 500 이니까 n^3 가능
// 

public class BJ11066_파일합치기2 {
    public static int k;
    public static int[] arr, sum;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            k = Integer.parseInt(br.readLine());
            arr = new int[501];
            sum = new int[501];
            dp = new int[501][501];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= k; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                sum[j] = sum[j-1]+num;
            }
            for(int j = 0; j <= k; j++){
                Arrays.fill(dp[j],-1);
            }
            int answer = solve(1,k);
            //System.out.println(answer);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int solve(int start, int end){

        if(start == end-1) return arr[start]+arr[end];
        else if(start == end) return 0;
        
        if(dp[start][end] == -1){
            dp[start][end] = Integer.MAX_VALUE;
            for(int i = start; i < end; i++){
                dp[start][end] = Math.min(dp[start][end],solve(start,i)+solve(i+1,end)+sum[end]-sum[start-1]);
            }
        }
        return dp[start][end];
    }


}

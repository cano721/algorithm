import java.io.*;
import java.util.*;

/**
 * nCk = n-1Ck-1 + n-1Ck
 * 디피로 풀기
 */
public class BJ11050_이항계수1 {

    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        dp = new int[11][11];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bc(n,k);
        bw.write(dp[n][k] + "\n");
        bw.flush();
        bw.close();
    }

    public static int bc(int n, int k){
        if(dp[n][k] != 0){
            return dp[n][k];
        }

        if(n == k || k == 0){
            return dp[n][k] = 1;
        }

        return dp[n][k] = bc(n-1,k-1) + bc(n-1,k);
    }
}

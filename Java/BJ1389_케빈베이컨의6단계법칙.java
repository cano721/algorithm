/**
 * 플로이드 와샬 풀이(정점에서 각 정점까지의 최소비용 찾기)
 */

import java.util.*;
import java.io.*;

public class BJ1389_케빈베이컨의6단계법칙 {

    public static int n,m,max;
    public static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        max = 1_000_000;

        // 초기값
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                dist[i][j] = max;
            }
        }

        // 관계 설정
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dist[start][end] = 1;
            dist[end][start] = 1;
        }

        floyd();

        int min_cnt = Integer.MAX_VALUE;
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int temp = 0;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                temp += dist[i][j];
            }
            if(min_cnt > temp){
                min_cnt = temp;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    public static void floyd(){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}

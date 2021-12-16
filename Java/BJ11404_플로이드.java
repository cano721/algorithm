
/**
 * 각정점에서 정점으로 갈 수 있는지 여부를 저장
 * 플로이드와샬로 풀 예정(각정점에서 정점으로 최소비용 이동)
 * n^3
 */

import java.util.*;
import java.io.*;
public class BJ11404_플로이드 {

    public static int n, m;
    public static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];

        // 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        StringTokenizer st;

        // 1개의 간선을 통해 갈 수 있는 값 저장
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
                
            dist[a][b] = Math.min(dist[a][b],cost);
        }

        floyd();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j] == Integer.MAX_VALUE){
                    bw.write(0 + " ");
                }else{
                    bw.write(dist[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void floyd(){
        // 중간노드 
        for(int mNode = 1; mNode <= n; mNode++){
            // 시작노드
            for(int start = 1; start <= n; start++){
                // 도착노드
                for(int end = 1; end <= n; end++){
                    // 둘중에 하나라도 최대값이면 변경할 필요 없음..
                    if(dist[start][mNode] == Integer.MAX_VALUE || dist[mNode][end] == Integer.MAX_VALUE) continue;
                    dist[start][end] = Math.min(dist[start][end], dist[start][mNode] + dist[mNode][end]);
                }
            }
        }
    }
}

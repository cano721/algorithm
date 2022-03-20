/*
   1. U를 루트로 하는 서브트리에 속한 정점의 수를 출력
   
   2. tree DP
   
   3. DFS를 통해 서브트리의 노드 개수를 DP에 저장
*/

import java.util.*;
import java.io.*;

public class BJ15681_트리와쿼리 {

    public static ArrayList<Integer>[] tree;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int r = Integer.parseInt(st.nextToken()); // 루트 정점
        int q = Integer.parseInt(st.nextToken()); // 쿼리 개수

        dp = new int[n+1];

        tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        checkSubTree(r); // 정점부터 서브트리 노드 수 파악

        for(int i = 0; i < q; i++){
            int u = Integer.parseInt(br.readLine());
            bw.write(dp[u] +"\n");
        }

        bw.flush();
        bw.close();
        
    }

    
    public static int checkSubTree(int node){
        if(dp[node] != 0){ //현재 노드를 방문했었으면 0반환
            return 0;
        } 
        
        dp[node] = 1; // 현재 노드 1개 초기화

        for(int next : tree[node]){
            dp[node] += checkSubTree(next); // 자식노드의 개수 더하기
        }

        return dp[node];
    }
}
import java.io.*;
import java.util.*;

public class BJ1260_DFS와BFS {

    public static int n,m,v;
    public static int[][] arr;
    public static Boolean[] visited;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1][n+1];
        visited = new Boolean[n+1];
        // 간선설정
        for(int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        Arrays.fill(visited,false);
        dfs(v);
        bw.write("\n");
        Arrays.fill(visited,false);
        bfs(v);
        bw.flush();
        bw.close();
    }

    public static void dfs(int node) throws IOException{

        visited[node] = true;
        bw.write(node + " ");

    

        for(int i= 1; i <= n; i++){
            if(arr[node][i] == 1  && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int node) throws IOException{
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur+" ");

            for(int j = 1; j <= n; j++){
                if(arr[cur][j] == 1 && !visited[j]){
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}

import java.util.*;
import java.io.*;

/**
 * 
 */
public class BJ2252_줄세우기 {

    public static int n, m;
    public static ArrayList<Integer>[] graph;
    public static int[] degree;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        degree = new int[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            degree[b]++;
        }

        topologySort();
        bw.flush();
        bw.close();
    }

    public static void topologySort() throws IOException{
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur + " ");
            for(int v: graph[cur]){
                degree[v]--;
                if(degree[v] == 0){
                    q.offer(v);
                }
            }
        }
    }
}

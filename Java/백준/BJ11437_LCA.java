import java.util.*;
import java.io.*;

public class BJ11437_LCA {

    public static int n,m;
    public static ArrayList<Integer>[] tree;
    public static int[] parent,depths;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];

        for(int i = 0; i<= n; i++){
            tree[i] = new ArrayList<>();
        }

        parent = new int[n+1];
        depths = new int[n+1];

        StringTokenizer st;
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1,1);

        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = LCA(a,b);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int LCA(int a, int b){
        int adep = depths[a];
        int bdep = depths[b];

        while(adep > bdep){
            a = parent[a];
            adep--;
        }

        while(bdep > adep){
            b = parent[b];
            bdep--;
        }
        while(a != b){
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static void dfs(int current, int depth){
        depths[current] = depth;
        for(int next : tree[current]){
            if(depths[next] == 0){
                parent[next] = current;
                dfs(next,depth+1);
            }
        }
    }
}

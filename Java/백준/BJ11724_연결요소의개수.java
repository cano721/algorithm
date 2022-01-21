/**
 * bfs 풀이
 */

import java.util.*;
import java.io.*;

public class BJ11724_연결요소의개수 {
    
    public static int answer,n,m;
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs(){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(visited[i] == false){
                visited[i] = true;
                answer++;

                q.offer(i);

                while(!q.isEmpty()){
                    int cur = q.poll();

                    for(int j = 0; j < graph[cur].size(); j++){
                        int next = graph[cur].get(j);
                        if(visited[next] == false){
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }
        }
    }
}

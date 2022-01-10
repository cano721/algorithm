import java.util.*;
import java.io.*;

public class Test {

    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static boolean[][] dist;
    static int N, M;
    static int[] target;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
    static void pro() {
        //연결 확인하려고 각 노드에서 출발하여 bfs를 돌림
        for (int i = 1; i <= N; i++) bfs(i);
//        for (int i = 1; i <= N; i++) {
//            for (Integer integer : A[i]) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
        int cnt = 0;
        for (int i = 1; i <= M - 1; i++) {
            if(dist[target[i]][target[i+1]]) {
                cnt++;
            }
        }
        if(cnt == M - 1) System.out.println("YES");
        else System.out.println("NO");
    }
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : A[cur]) {
                if(dist[start][next]) continue;
                q.offer(next);
                dist[start][next] = true;
            }
        }
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = atoi(br.readLine());
        M = atoi(br.readLine());
        target = new int[M + 1];
        A = new ArrayList[N + 1];
        dist = new boolean[N + 1][N + 1];
        for (int i = 0; i <= N; i++) A[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= i; k++) st.nextToken();
            for (int j = i+1; j <= N; j++) {
                int num = atoi(st.nextToken());
                if(num == 1){
                    A[i].add(j);
                    A[j].add(i);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            target[i] = atoi(st.nextToken());
        }
    }
}

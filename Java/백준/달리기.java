
/**
 * 1. 1000*1000
 * 
 * 2. 4방향 k만큼 이동 가능
 * 
 * 3. 시작지점, 도착지점 주어짐.
 * 
 * 4. 최소 시간 반환 또는 불가능하면 -1 반환
 * 
 * --------------------------------------
 * 
 * 1. bfs로 맵 체크?(10^6)
 * 
 * 2. 방문여부 체크. 벽 체크.
 * 
 * 3. 이동 가능시 이동.
 * 
 * 4. 최소 시간 반환.
 * 
 * 중요 포인트.
 * visited를 int로 체크하여, 현재 횟수+1 보다 적게 들어온적이 있으면 break찍기.
 */

import java.util.*;
import java.io.*;

public class 달리기 {

    public static int n,m,k;
    public static int[][] map;
    public static class Point{
        int x;
        int y;
        int cnt;
        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                char cur = str.charAt(j);
                if(cur == '#'){
                    map[i][j] = 1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken())-1;
        int sy = Integer.parseInt(st.nextToken())-1;
        int ex = Integer.parseInt(st.nextToken())-1;
        int ey = Integer.parseInt(st.nextToken())-1;

        System.out.println(bfs(sx,sy,ex,ey));
    }

    public static int bfs(int sx, int sy, int ex, int ey){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sx,sy,0));

        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }

        visited[sx][sy] = 0;

        int[][] dirXY = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x == ex && cur.y == ey){
                return cur.cnt;
            }

            for(int idx = 0; idx < 4; idx++){
                for(int i = 1; i <= k; i++){
                    int nx = cur.x + dirXY[idx][0]*i;
                    int ny = cur.y + dirXY[idx][1]*i;

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                        break;
                    }

                    if(map[nx][ny] == 1){
                        break;
                    }

                    if(visited[nx][ny] < cur.cnt+1){
                        break;
                    }
                    if(visited[nx][ny] == Integer.MAX_VALUE){
                        visited[nx][ny] = cur.cnt +1;
                        q.offer(new Point(nx,ny,cur.cnt +1));
                    }
                }
            }
        }

        return -1;
    }
}

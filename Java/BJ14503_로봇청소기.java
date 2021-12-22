/*
    1. 현재 보는 방향 기준으로 왼쪽방이 청소 안되어있으면 청소
    2. 왼쪽 방향 청소 공간 x -> 왼쪽으로 회전만
    3. 4방향 다 청소 되어있거나 막다른 곳이면 한칸 후진
    4. 3번이면서 후진도 불가능하면 멈추기


*/

import java.util.*;
import java.io.*;

public class BJ14503_로봇청소기 {

    // 북동남서
    public static int[] dirX = {-1,0,1,0};
    public static int[] dirY = {0,1,0,-1};
    public static int n,m,answer;
    public static int[][] map;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵 크기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 맵초기화
        map = new int[n][m];

        // n 로봇개수 m 명령어 수
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st2.nextToken()); 
        int c = Integer.parseInt(st2.nextToken());
        int d = Integer.parseInt(st2.nextToken());
        
        for(int i = 0; i < n; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st3.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(answer);
    }

    static void clean(int r, int c, int d){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r,c,d});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int pos = cur[2];
            boolean check = false;
            // 청소안한 곳이면 청소
            if(map[x][y] == 0){
                answer++;
                map[x][y] = 2;
            }
            for(int i = 3; i >= 0; i--){
                // 왼쪽방향
                int lpos = (pos+i)%4;
                int nx = x + dirX[lpos];
                int ny = y + dirY[lpos];

                // 왼쪽방향이 갈 수 있는 곳인가
                if(0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] != 1){
                    // 청소가능한가
                    if(map[nx][ny] == 0){
                        q.offer(new int[] {nx,ny,lpos});
                        // 청소했으면 트루
                        check = true;
                        break;
                    }
                }
            }
            // 4방향 체크했지만 청소할 곳이 없으면
            if(check == false){
                int bpos = (pos+2)%4;
                int nx = x + dirX[bpos];
                int ny = y + dirY[bpos];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] != 1){
                    q.offer(new int[] {nx,ny,pos});
                }else{
                    break;
                }
            }
        }
    }
}

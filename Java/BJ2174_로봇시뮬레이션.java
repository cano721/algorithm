/*

*/

import java.util.*;
import java.io.*;

public class BJ2174_로봇시뮬레이션 {

    // 동서남북
    public static int[] dirX = {0,-1,0,1};
    public static int[] dirY = {1,0,-1,0};
    public static int a,b;
    public static Robot robots[] = new Robot[101];
    public static int[][] map;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵 크기
        b = Integer.parseInt(st.nextToken()); // 가로
        a = Integer.parseInt(st.nextToken()); // 세로

        // 맵초기화
        map = new int[a+1][b+1];
        for(int i = 0; i < a+1; i++){
            Arrays.fill(map[i],-1);
        }

        // n 로봇개수 m 명령어 수
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st2.nextToken()); 
        int m = Integer.parseInt(st2.nextToken());
        
        for(int i = 0; i < n; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            
            int y = Integer.parseInt(st3.nextToken());
            int x = Integer.parseInt(st3.nextToken());
            char d = st3.nextToken().charAt(0);

            int pos;
            if(d == 'E') pos = 0;
            else if(d == 'W') pos = 2;
            else if(d == 'S') pos = 1;
            else pos = 3;
            // 로봇 정보 담기
            robots[i+1] = new Robot(i+1,x, y, pos);
            // 맵에다 위치
            map[x][y] = i+1;
        }
        
        int errorId = 0;
        for(int i = 0; i < m; i++){
            StringTokenizer st4 = new StringTokenizer(br.readLine());
            
            int r_id = Integer.parseInt(st4.nextToken());
            char op = st4.nextToken().charAt(0);
            int r = Integer.parseInt(st4.nextToken());
            if(errorId > 0) continue;
            errorId = checkError(r_id, op, r);
            if(errorId == 1){
                System.out.printf("Robot %d crashes into the wall\n",r_id);
            }else if (errorId == 2){
                System.out.printf("Robot %d crashes into robot %d\n",r_id,robots[r_id].id);
            }
        }
        if(errorId ==0){
            System.out.println("OK");
        }
    }

    static int checkError(int r_id, char op, int r){
        for(int i = 0; i < r; i++){
            if(op == 'L'){
                robots[r_id].pos = (robots[r_id].pos+3)%4;
            }else if(op == 'R'){
                robots[r_id].pos = (robots[r_id].pos+1)%4;
            }else{
                int curX = robots[r_id].x;
                int curY = robots[r_id].y;
                int curPos = robots[r_id].pos;
                int nx = curX + dirX[curPos];
                int ny = curY + dirY[curPos];
                if(1 <= nx && nx <= a && 1 <= ny && ny <= b){
                    if(map[nx][ny] != -1){
                        robots[r_id].id = map[nx][ny];
                        return 2;
                    }
                }else{
                    return 1;
                }
                //System.out.println(nx + " " + ny);
                map[nx][ny] = r_id;
                map[curX][curY] = -1;
                robots[r_id].x = nx;
                robots[r_id].y = ny;
            }
        }
        return 0;
    }

    static class Robot{
        int id;
        int x,y;
        int pos;
        public Robot(int _id,int _x, int _y, int _pos){
            this.id = _id;
            this.x = _x;
            this.y = _y;
            this.pos = _pos;
        }
    }
}

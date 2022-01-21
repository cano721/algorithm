/**
 * 3차원 bfs로 실행
 * 
 */

import java.util.*;
import java.io.*;

public class BJ7569_토마토 {

    public static int[][][] box;
    public static int n,m,h,day;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[n][m][h];

        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < m; j++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1){
                        q.offer(new int[] {i,j,k,0});
                    }
                }
            }
        }

        bfs();
        if(!check()){
            System.out.println(-1);
        }else{
            System.out.println(day);
        }

    }

    public static void bfs(){
        int[] dirX = {0,0,0,0,1,-1};
        int[] dirY = {0,0,1,-1,0,0};
        int[] dirH = {1,-1,0,0,0,0};

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int a = cur[0];
            int b = cur[1];
            int c = cur[2];
            int d = cur[3];

            for(int idx = 0; idx < 6; idx++){
                int x = a + dirX[idx];
                int y = b + dirY[idx];
                int z = c + dirH[idx];

                if(0 <= x && x < n && 0 <= y && y < m && 0 <= z && z < h){
                    if(box[x][y][z] == 0){
                        box[x][y][z] = 1;
                        day = Math.max(day,d+1);
                        q.offer(new int[] {x,y,z,d+1});
                    }
                }
            }
        }
    }

    public static boolean check(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < h; k++){
                    if(box[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

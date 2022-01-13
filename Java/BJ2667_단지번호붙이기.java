/**
 * dfs& bfs 풀이(bfs 사용)
 * 
 * 1. 지도를 돌면서, 집을 만나면 bfs 실행
 * 
 * 2. bfs로 방문여부 및 개수 파악(각 번호 카운트 증가)
 * 
 * 3. bfs 종료 시 각 카운트 번호 출력
 * 
 * 4. 다시 지도 돌면서 체크(방문여부로 체크된 곳은 건너뛰기)
 */

import java.util.*;
import java.io.*;

public class BJ2667_단지번호붙이기 {
    
    public static int n;
    public static int[][] arr;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];


        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j) -'0';
            }
        }
        bfs();
        bw.flush();
        bw.close();
    }

    // 지도 돌면서 bfs 실행
    public static void bfs() throws IOException{

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        
        // 단지수 변수
        int apt = 0;
        // 단지별 집 수
        ArrayList<Integer> alist = new ArrayList<>();
        // 4방향 돌기위한 배열
        int[] dirX = {0,0,1,-1};
        int[] dirY = {1,-1,0,0};
        // 지도 돌기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 방문하지 않았고, 집이면
                if(visited[i][j] == false && arr[i][j] == 1){
                    apt++;
                    // 큐에 좌표 담기
                    q.offer(new int[] {i,j});
                    visited[i][j] = true;
                    int cnt = 1;

                    //bfs 실행
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        // 동서북남 돌기
                        for(int k = 0; k <4; k++){
                            int newX = cur[0] + dirX[k];
                            int newY = cur[1] + dirY[k];
                            // 지도내에 있는가
                            if(0 <= newX && newX < n && 0<= newY && newY < n){
                                // 방문하지 않았던 곳이면서 집이면,
                                if(visited[newX][newY] == false && arr[newX][newY] == 1){
                                    visited[newX][newY] = true; // 방문처리
                                    cnt++; // 카운트 증가
                                    q.offer(new int[] {newX,newY});
                                }
                            }
                        }
                    }
                    // 다했으면 개수 저장
                    alist.add(cnt);
                }
            }
        }

        //아파트 단지와 개수 출력(개수 출력시 오름차순 정렬)
        bw.write(apt +"\n");
        Collections.sort(alist);
        for(int cnt : alist){
            bw.write(cnt +"\n");
        }
    }

  
}

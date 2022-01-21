/**
 * 구현
 * 
 * 1. 사다리 정보와 뱀의 정보를 배열에 담기
 * 
 * 2. 1~100칸의 정보를 만들고 각 칸에 몇번만에 왔는지를 저장하면서 이동(방문했던 칸은 방문하지 않음)
 * 
 * 3. 최종 100번째칸에 왔을때 몇번만에 왔는지 출력
 * 
 */

import java.util.*;
import java.io.*;


public class BJ16928_뱀과사다리게임 {

    public static int[] map = new int[101];
    public static int[] cmap = new int[101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        // 사다리 정보 저장
        for(int i = 0; i < ladder; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start] = end;
        }

        // 뱀 정보 저장
        for(int i = 0; i < snake; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start] = end;
        }
        // 게임시작
        check();
        System.out.println(cmap[100]);
    }

    //게임
    public static void check(){
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        cmap[1] = 0;
        while(!q.isEmpty()){

            int cur = q.poll();

            if(cur == 100){
                break;
            }
            // 주사위 굴리기
            for(int i = 1; i <= 6; i++){
                
                if(cur+i > 100) continue;

                // 이동할 곳이 사다리,뱀 없고 방문하지 않았던 곳
                if(cmap[cur+i] == 0 && map[cur+i] == 0){
                    cmap[cur+i] = cmap[cur]+1;
                    q.offer(cur+i);
                }
                // 사다리나 뱀이 있음
                else if(map[cur+i] != 0){
                    // 사다리 뱀의 최종위치
                    int move = map[cur+i];
                    //최종위치 방문 안했던 곳이면 방문
                    if(cmap[move] == 0){
                        cmap[move] = cmap[cur]+1;
                        q.offer(move);
                    }
                }
            }
        }
    }
}

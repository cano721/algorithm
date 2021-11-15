/*
    해당 숫자를 넣어보고 체크하기!
*/

import java.io.*;
import java.util.*;

public class BJ2580_스도쿠 {
    public static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 맵 채우기
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 백트래킹 돌기
        solve(0,0);
    }

    public static void solve(int x,int y){
        // 다 완료되엇을때
        if(x > 8){
            for(int ai = 0; ai < 9; ai++){
                for(int aj = 0; aj <9; aj++){
                    System.out.print(arr[ai][aj] + " ");
                }
                System.out.println();
            }
            // 출력했다면 종료
            System.exit(0);
        }
        // 안채워져 있다면 채우기
        if(arr[x][y] == 0){
            // 1~9까지 
            for(int i = 1; i < 10; i++){
                arr[x][y] = i;
                // 넣어도 괜찮은지 체크
                Boolean flag = check(i,x,y);
                // 괜찮다면 다음꺼 확인
                if(flag){
                    if(y == 8){
                        solve(x+1,0);
                    }else{
                        solve(x,y+1);
                    }
                }
                // 초기화
                arr[x][y] = 0;
            }
        }
        //이미 채워져 있었다면 다음꺼 확인
        else{
            //다음 위치 체크
            if(y == 8){
                solve(x+1,0);
            }else{
                solve(x,y+1);
            }
        }
    }

    public static boolean check(int i,int x,int y){

        // 세로 방향 체크
        for(int ci = 0; ci < 9; ci++){
            // 방금 넣은거면 패스
            if(ci == x) continue;
            // 그외의 세로방향에 i랑 같은게 있으면 false로 변환
            if(arr[ci][y] == i){
                return false;
            }
        }
        // 가로 방향 체크
        for(int cj = 0; cj < 9; cj++){
            if(cj == y) continue;
            if(arr[x][cj] == i){
                return false;
            }
        }

        //81칸을 9개로 쪼갰을때 몇번째꺼인지 확인하기위한것
        int nx = x/3;
        int ny = y/3;

        // 9개 칸 확인
        for(int bi = nx*3; bi < nx*3+3; bi++){
            for(int bj = ny*3; bj < ny*3+3; bj++){
                // 현재 넣은것이면 패스
                if(bi == x && bj == y) continue;
                // 다른 부분이 현재 넣은거랑 같으면 false 반환
                if(arr[bi][bj] == i){
                    return false;
                }
            }
        }

        // 3개다 확인했는데 false가 없으면 true 반환

        return true;
    }
}


import java.util.*;
import java.io.*;

// 실패 나중에 다시 풀기!

// 최대 15*15 맵에서 n개의 퀸이 놓였을때
// 대각선 직선 사이에 서로서로 닿지 않아야함.
// 어차피 각 줄에는 한개밖에 못 둠.
// 2차원이 아닌 1차원으로 사용해서 시간복잡도 초과 안나게 할것

// 백트래킹을 돌면서 각줄마다 몇번 위치에 놓는지 담고
// 각 퀸을 놓을때마다 놓을 수 있는 위치인지 체크함수 돌리기
// n번째줄에 도달 햇을때 정답 +1



public class BJ9663_N_Queen {

    public static int n,answer;
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        solve(0);
        System.out.println(answer);
    }
    
    // n개의 퀸 고르기
    public static void solve(int stage){
        
        if(stage == n){
            // n개 다 골랐으면 정답 +1
            answer++;
            return;
        }

        for(int i = 0; i < n; i++){
            arr[stage] = i;
            if(queenCheck(stage)){
                solve(stage+1);
            }
        }
    }

    // 공격할 수 있는지 없는지 체크하는 함수
    public static Boolean queenCheck(int stage){
        // 기존에 고른 퀸들이
        for(int idx = 0; idx < stage; idx++){
            // 현재 고른 퀸의 위치랑 직선상에 있거나
            // 대각선상에 있는지 확인(가로 세로 절대값이 같으면 대각선에 해당)
            if(arr[stage] == arr[idx] || Math.abs(stage-idx) == Math.abs(arr[stage]-arr[idx])){
                // 있으면 false
                return false;
            }
        }
        //없으면 true
        return true;
    }
}

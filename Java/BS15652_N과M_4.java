/*
   1~N중에서 M개를 고른 수열
   중복 가능,오름차순 정렬

   전에 고른 숫자를 같이 매개변수로 보내서
   그 숫자부터 돌게 만들기


*/


import java.util.*;
import java.io.*;

public class BS15652_N과M_4 {

    public static int n;
    public static int m;
    
    // 숫자 배열
    public static int[] arr;

    // 선택숫자 배열
    public static int[] choice;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        //숫자 배열 길이 생성
        arr = new int[n+1];

        // 선택담을 배열 생성
        choice = new int[m];

        solve(0,1);
        bw.flush();
        bw.close();
    }

    public static int solve(int stage,int pnum) throws IOException{

        // 다 골랐을때
        if(stage == m){
            //선택 배열 돌면서 출력
            for(int idx = 0; idx < m; idx++){
                bw.write(choice[idx] + " ");
                }
                bw.write("\n");
            return 0;
        }
        
        // 숫자를 돌면서 고르기
        for(int i =pnum; i <= n; i++){
            
            // 고른숫자 담기
            choice[stage] = i;
            // 숫자 사용한것으로 표기
            arr[i] = 1;
            // 다음숫자 고르러 가기
            solve(stage+1,i);
        }
        return 0;
    }
}
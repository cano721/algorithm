/**
 * 분할정복 문제
 * 
 * 1) 숫자 파악
 * 
 * 2) 전체 숫자가 같지 않으면, 4분할
 * 
 * 3) 각 분할정보를 기록
 */

import java.util.*;
import java.io.*;

public class BJ1992_쿼드트리 {
    
    public static int[][] arr;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];


        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j) -'0';
            }
        }
        slice(n,0,0);
        bw.flush();
        bw.close();
    }

    // 분할 함수
    public static void slice(int size, int n, int m) throws IOException{

        // 다 같은 숫자면 더하기
        if(numCheck(size,n,m)){
            bw.write(String.valueOf(arr[n][m]));
        // 아니면 9분할
        }else{
            int newsize = size/2;
            bw.write("(");
            slice(newsize, n, m); // 1사분면
            slice(newsize, n,m+newsize); // 2사분면
            slice(newsize, n+newsize,m); // 3사분면
            slice(newsize, n+newsize, m+newsize); // 4사분면
            bw.write(")");
        }
    }

    // 숫자체크 함수
    public static boolean numCheck(int size, int n, int m){
        int first = arr[n][m];
        boolean check = true;
        for(int i = n; i < n+size; i++){
            for(int j = m; j < m+size; j++){
                if(first != arr[i][j]){
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
}

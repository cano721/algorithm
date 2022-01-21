/**
 * 구현 문제
 * 
 * 1. 마지막 해인 M,N 과 현재 해인 x,y가 주어지면 x,y는 몇번째 해인지 구하기
 * 
 * 2. x,y 중 하나를 고정으로 두고, 더해가면서 구하면 됨
 * 
 * 3.  x,y 둘다 0은 나올 수 없으니 % 편하게 써도 됨
 * 
 */

import java.util.*;
import java.io.*;

public class BJ6064_카잉달력 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 
            year(n,m,x,y);
            if(x==y){
                bw.write(x +"\n");
            }else{
                bw.write(year(n,m,x,y) +"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int year(int n, int m, int x, int y){
        //x를 고정
        for(int i = x; i < n*m; i+=n){
            if(i %m == y){
                return i;
            }
        }
        return -1;
    }
}

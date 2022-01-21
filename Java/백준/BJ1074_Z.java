import java.util.*;
import java.io.*;


/**
 * 분할정복문제
 * 
 * 큰 배열을 작은 배열로 나누어서 계산하기(재귀 사용)
 * 
 * 가장 큰 사이즈를 체크하고(가로,세로)
 * 그 사이즈의 절반안에 있는지 체크하는 형태로
 * 4분면으로 나누어서 확인.
 * 
 */
public class BJ1074_Z {
    public static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2,n);
        recursion(size, r, c);
        System.out.println(cnt);
    }

    public static void recursion(int size, int r, int c) {
        if(size == 1){
            return;
        }

        // 1사분면안에 있음
        if(r < size/2 && c < size/2){
            recursion(size/2, r, c);
        // 2사분면안에 있음
        }else if(r < size/2 && c >= size/2){
            // 1사분면 더해주기
            cnt += (size * size)/4;
            recursion(size/2, r, c - size/2);
        // 3사분면안에 있음
        }else if(r >= size/2 && c < size/2){
            // 1,2사분면 더해주기
            cnt += (size * size)/4*2;
            recursion(size/2, r - size/2, c);
        // 4사분면
        }else{
            // 1,2,3사분면 더해주기
            cnt += (size*size)/4*3;
            recursion(size/2, r -size/2, c - size/2);
        }
    }
} 

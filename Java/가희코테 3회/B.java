/**
 * 구현 문제
 * 
 * 가희가 해당 건물까지 볼 수 있다는건
 * 
 * 그 건물이 가장 높은 건물이라는 뜻
 * 
 * 나머지 숫자는 배정
 * 
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class B {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        int cnt = 0;
        int num = 1;
        for(int i = n-1; i > 0; i--){
            if(cnt == b-1){
                break;
            }
            cnt++;
            arr[i] = num++;
        }


        bw.flush();
        bw.close();
   } 
}

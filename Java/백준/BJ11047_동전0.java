/**
 * 구현
 * 
 * 1. 동전 큰 것부터 확인
 * 
 * 2. k원보다 작거나 같으면 동전으로 나누어 몇개까지 사용가능한지 확인
 * 
 * 3. 몫이 사용개수 이므로 몫만큼 정답 증가
 * 
 * 4. 나머지를 기준으로 하위 동전 체크
 * 
 * 5. k == 0으로 전환 시 정답 출력
 * 
 */

import java.util.*;
import java.io.*;

public class BJ11047_동전0 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i] <= k){
                cnt += k/arr[i];
                k %= arr[i];
            }
            if(k == 0){
                System.out.println(cnt);
                break;
            }
        }

    }
}

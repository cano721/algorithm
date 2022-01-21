/**
 * 구현 브루트포스 문제
 * 
 * 해시에 의상종류별 개수 저장
 * 
 * 각 의상 종류별 개수+1 을 곱한다음 다 안고른 상태를 빼면 답
 * 
 * 예) headgear = 2, eyewear = 1
 * 3*2 = 6 -1 = 5
 * 
 */

import java.util.*;
import java.io.*;

public class BJ9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());

        // 테스트
        for(int tc = 0; tc <t; tc++){

            // 의상 수
            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type,map.getOrDefault(type,0)+1);
            }
            int result = 1;
            //의상 종류별 수
            for(int v : map.values()){
                result *= (v+1);
            }

            if(map.size() == 0){
                bw.write(0 +"\n");
            }else{
                bw.write(result-1 +"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

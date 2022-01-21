/**
 * 구현
 * 
 * 1. 해시맵에 주소: 비밀번호 매칭하여 저장
 * 
 * 2. 해시맵에서 찾아서 출력
 * 
 */

import java.util.*;
import java.io.*;

public class BJ17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,String> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String pwd = st.nextToken();

            map.put(key,pwd);
        }

        for(int i = 0; i < m; i++){
            String find = br.readLine();
            bw.write(map.get(find) +"\n");
        }

        bw.flush();
        bw.close();
    }
}

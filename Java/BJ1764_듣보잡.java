/*
    1. 트리맵에 넣고(자동 키 정렬)
    2. 둘다 들어갔으면 인원수 증가 및 듣보잡으로 체크

*/

import java.util.*;
import java.io.*;

public class BJ1764_듣보잡 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 0;

        Map<String,Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++){
            String name = br.readLine();
            map.put(name,1);
        }
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            if(map.get(name) != null){
                map.put(name,2);
                cnt++;
            }
        }
        
        bw.write(cnt +"\n");
        for(String key : map.keySet()){
            if(map.get(key) == 2){
                bw.write(key + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

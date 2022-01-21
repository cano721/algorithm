import java.io.*;
import java.util.*;

/**
 * 해쉬맵에 숫자 key: 갯수 value로 저장
 * 찾는 숫자를 해쉬맵에서 불러서 출력
 */
public class BJ10816_숫자카드2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.get(num) != null){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int number = Integer.parseInt(st.nextToken());
            int cnt = 0;
            if(map.get(number) != null){
                cnt = map.get(number);
            }
            bw.write(cnt + " ");
        }

        bw.flush();
        bw.close();
    }
}

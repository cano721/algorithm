import java.util.*;
import java.io.*;


/**
 * 구현
 * 땅의 높이를 1~256까지 정해놓고
 * 맵 전체를 돌면서 작업시간 체크
 * 다 했을때 인벤토리 블록의 개수가 -면 그 작업은 패스
 * 0이거나 +일때 시간이 더 단축되었다면 변경
 * 같을경우는 높이가 가장 큰 것을 출력하는것이므로
 * 제일 높은것부터 시작하여 시간 변경되었을때 땅높이 변경
 */
public class BJ18111_마인크래프트 {

    public static int n,m,b;
    public static int[][] map;
    public static long time,height;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        time = Integer.MAX_VALUE;
        ground();
        System.out.println(time + " " + height);
    }

    public static void ground(){
        // 높이 지정
        for(int i = 256; i >= 0; i--){
            int curb = b;
            long curTime = 0;
            for(int a = 0; a < n; a++){
                for(int b = 0; b < m; b++){
                    // 지정 높이보다 높으면 블록 제거
                    if(map[a][b] > i){
                        int diff = map[a][b] - i;
                        curTime += 2*diff;
                        curb += diff;
                    // 낮으면 블록추가
                    }else if(map[a][b] < i){
                        int diff = i - map[a][b];
                        curTime += diff;
                        curb -= diff;
                    }
                }
            }
            //맵을 다 돌았을때 체크

            // 현재 인벤토리 블록이 마이너스면 패스
            if(curb < 0){
                continue;
            }
            // 시간이 단축되었으면 변경
            if(curTime < time){
                time = curTime;
                height = i;
            }
        }
    }
}

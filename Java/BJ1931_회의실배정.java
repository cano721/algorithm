import java.util.*;
import java.io.*;

/**
 * 우선순위큐로 회의시간을 다 집어넣고(끝나는시간,시작시간 기준으로 오름차순)
 * 빼냈을때 현재시간보다 시작시간이 이미 지났으면 패스
 * 시작시간이 현재시간보다 이후거나 같으면
 * 개수 추가 후 현재시간을 끝나는시간으로 변경
 */
public class BJ1931_회의실배정 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            q.offer(new int[] {start,end});
        }

        int curTime = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] >= curTime){
                cnt++;
                curTime = cur[1];
            }
        }

        System.out.println(cnt);
    }
}

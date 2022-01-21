/**
 * 최소힙과 최대힙을 만들고 맵을 만들어
 * 
 * 숫자가 들어올때마다 맵과 최소힙, 최대힙에 저장
 * 
 * 출력할땐 최
 * 
 * 
 * 
 */
import java.util.*;
import java.io.*;

public class BJ7662_이중우선순위큐 {
    
    public static Map <Integer,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;



        int t = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < t; tc++){
            
            int k = Integer.parseInt(br.readLine());
            
            PriorityQueue<Integer> minq = new PriorityQueue<>();
            PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                
                String c = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                // 입력
                if(c.equals("I")){
                    minq.offer(num);
                    maxq.offer(num);
                    map.put(num,map.getOrDefault(num,0) +1);
                // 출력
                }else{
                    // 비어있으면 건너뛰기
                    if(map.size() == 0){
                        continue;
                    }
                    // 최대값 출력일때
                    if(num == 1){
                        removeq(maxq);
                    }else{
                        removeq(minq);
                    }
                }
            }

            if(map.size() == 0){
                bw.write("EMPTY\n");
            }else{
                int max = removeq(maxq);
                bw.write(max + " ");
                if(map.size() > 0){
                    max = removeq(minq);
                }
                bw.write(max + "\n");
            }
        }
        bw.flush();
        bw.close();
    }


    // 선택된 숫자 반환
    public static int removeq(Queue<Integer> q){
        int a;
        while(true){
            // 최대값 뽑기
            a = q.poll();
            // 그 최대값의 숫자가 남아있냐
            int cnt = map.getOrDefault(a, 0);
            
            if(cnt == 0){
                continue;
            }else if(cnt == 1){
                map.remove(a);
            }else{
                map.put(a,cnt-1);
            }
            break;
        }
        return a;
    }
}
 
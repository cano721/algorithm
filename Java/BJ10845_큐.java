import java.io.*;
import java.util.*;

/**
 * 구현
 */
public class BJ10845_큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
            }else if(str.equals("pop")){
                if(q.size() > 0){
                    bw.write(q.poll() + "\n");
                }else{
                    bw.write(-1 + "\n");
                }
            }else if(str.equals("size")){
                bw.write(q.size()+ "\n");
            }else if(str.equals("empty")){
                if(q.size() == 0){
                    bw.write(1 + "\n");
                }else{
                    bw.write(0 + "\n");
                }
            }else if(str.equals("front")){
                if(q.size() > 0){
                    bw.write(q.peekFirst() + "\n");
                }else{
                    bw.write(-1 + "\n");
                }
            }else if(str.equals("back")){
                if(q.size() > 0){
                    bw.write(q.peekLast() + "\n");
                }else{
                    bw.write(-1 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

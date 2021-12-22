import java.io.*;
import java.util.*;

/**
 * 구현
 */
public class BJ10866_덱 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                q.offerLast(num);
            }else if(str.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                q.offerFirst(num);
            }else if(str.equals("pop_front")){
                if(q.size() > 0){
                    bw.write(q.pollFirst() + "\n");
                }else{
                    bw.write(-1 + "\n");
                }
            }else if(str.equals("pop_back")){
                if(q.size() > 0){
                    bw.write(q.pollLast() + "\n");
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

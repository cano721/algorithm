/**
 * 1. 디큐 구현풀이
 * 
 * 2. n개의 명령의 수에 따라 수행
 * 
 * 3. 출력 명령문 마다 출력
 * 
 */

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // Queue<Integer> q = new LinkedList<>();
        
        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st;

        for(int i = 0; i < n; i++){

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());

                dq.offer(num);
            }else if(command.equals("pop")){
                int num = dq.isEmpty() == true ? -1 : dq.poll();
                bw.write(num +"\n");
            }else if(command.equals("size")){
                bw.write(dq.size() +"\n");
            }else if(command.equals("empty")){
                int num = dq.isEmpty() == true ? 1 : 0;
                bw.write(num + "\n");
            }else if(command.equals("front")){
                int num = dq.isEmpty() == true ? -1 : dq.peekFirst();
                bw.write(num +"\n");
            }else{
                int num = dq.isEmpty() == true ? -1 : dq.peekLast();
                bw.write(num +"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
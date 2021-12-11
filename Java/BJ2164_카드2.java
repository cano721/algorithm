import java.io.*;
import java.util.*;

/**
 * 구현 deque구조를 통해 설명한대로 진행
 * 시간복잡도 O(n)
 */
public class BJ2164_카드2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1; i <= n; i++){
            dq.offerLast(i);
        }
        while(dq.size() > 1){
            dq.pollFirst();
            dq.offerLast(dq.pollFirst());
        }
        bw.write(dq.peekFirst() +"\n");
        bw.flush();
        bw.close();
    }
}

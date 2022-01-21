import java.io.*;
import java.util.*;

/**
 * 구현
 */
public class BJ10828_스택 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> l = new Stack<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                l.push(num);
            }else if(str.equals("pop")){
                if(l.size() > 0){
                    bw.write(l.pop() + "\n");
                }else{
                    bw.write(-1 + "\n");
                }
            }else if(str.equals("size")){
                bw.write(l.size()+ "\n");
            }else if(str.equals("empty")){
                if(l.size() == 0){
                    bw.write(1 + "\n");
                }else{
                    bw.write(0 + "\n");
                }
            }else if(str.equals("top")){
                if(l.size() > 0){
                    bw.write(l.peek() + "\n");
                }else{
                    bw.write(-1 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

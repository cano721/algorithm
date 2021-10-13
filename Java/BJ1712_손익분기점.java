import java.io.*;
import java.util.*;

public class BJ1712_손익분기점 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(b >= c){
            System.out.println(-1);
        }else{
            int answer = a /(c-b); // 자동버림처리. 소수점이 나와도 됨. 1개단위이니 answer+1을 할거기때문에!
            System.out.println(answer+1);
        }
    }
}

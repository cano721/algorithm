import java.io.*;
import java.util.*;

public class BJ2908_상수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        
        String a = st.nextToken();
        StringBuffer sb = new StringBuffer(a);
        int num1 = Integer.parseInt(sb.reverse().toString());
        
        String b = st.nextToken();
        StringBuffer sb2 = new StringBuffer(b);
        int num2 = Integer.parseInt(sb2.reverse().toString());

        System.out.println(Math.max(num1,num2));
    }
}
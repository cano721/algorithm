import java.io.*;
import java.util.*;

public class BJ1152_단어의개수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = 0;
        while(st.hasMoreTokens()){
            st.nextToken();
            num += 1;
        }
        System.out.println(num);
    }
}

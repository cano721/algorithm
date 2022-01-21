import java.io.*;
import java.util.*;

public class BJ1929_소수구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for(int i = start; i <= end; i++){
            Boolean check = true;
            if(i < 2){
                check = false;
            }
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i%j == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println(i);
            }
        }
    }
}

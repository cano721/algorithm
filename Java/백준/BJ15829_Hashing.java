import java.util.*;
import java.io.*;


/**
 * 구현
 */
public class BJ15829_Hashing {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int l = Integer.parseInt(br.readLine());

        int m = 1234567891;
        long r = 1;
        String str = br.readLine();

        long sum = 0;

        for(int i = 0; i < str.length(); i++){
            int num = str.charAt(i)-96;
            sum += (num*r)%m;
            r*=31;
            r%=m;
        }
        
        sum%=m;
        System.out.println(sum);
    }
}

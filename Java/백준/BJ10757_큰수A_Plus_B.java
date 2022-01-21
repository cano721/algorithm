import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BJ10757_큰수A_Plus_B {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        
        a = a.add(b);
        System.out.println(a.toString());

    }
}
import java.io.*;
import java.util.*;

public class BJ2447_별찍기_10 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    public static int fibo(int num){
        if(num == 0) return 0;

        if(num == 1) return 1;

        return fibo(num-1)+fibo(num-2);
    }
}

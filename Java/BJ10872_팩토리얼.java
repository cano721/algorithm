import java.io.*;
import java.util.*;

public class BJ10872_팩토리얼 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(fact(n));
    }

    public static int fact(int num){
        if(num == 0) return 1;

        return num*fact(num-1);
    }
}

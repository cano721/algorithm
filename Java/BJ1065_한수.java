import java.io.*;
import java.util.*;

public class BJ1065_한수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        if (n <100){
            answer = n;
        }else{
            answer = 99;
            for (int i = 100; i <= n; i++){
                int check1 = i/100 - i%100/10;
                int check2 = i%100/10 - i%10;
                
                if (check1 == check2){
                    answer +=1;
                }
            }
        }
        System.out.println(answer);
    }
}

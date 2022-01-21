import java.io.*;
import java.util.*;

public class BJ2581_소수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        int answer = 0;
        int min = 0;

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
               answer += i;
               if(min == 0){
                   min = i;
               }
           }
       }

       if(answer == 0){
           System.out.println(-1);
       }else{
           System.out.println(answer);
           System.out.println(min);
       }

    }
}
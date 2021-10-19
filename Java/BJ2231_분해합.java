import java.util.*;
import java.io.*;

public class BJ2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int n = Integer.parseInt(br.readLine());
        Boolean check = true;
        for(int i = 0; i <= n; i++){
            int num = i;
            int checkNum = num;
            while( num >0){
                checkNum += num%10;
                num /= 10;
            }
            if(checkNum == n){
                System.out.println(i);
                check = false;
                break;
            }
        }
        if(check) System.out.println(0);

    }
}
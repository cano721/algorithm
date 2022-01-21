import java.io.*;
import java.util.*;

public class BJ11653_소인수분해 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if(num != 1){
            Boolean check = true;
            while(check){
                check = false;
                for(int i = 2; i <= Math.sqrt(num); i++){
                    if(num % i == 0){
                        System.out.println(i);
                        num /= i;
                        check = true;
                        break;
                    }
                }
            }
            System.out.println(num);
        }
    }
}

import java.io.*;
import java.util.*;

public class BJ4948_베르트랑공준 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                break;
            }
            int cnt = 0;

            for(int a = n+1; a <= 2*n; a++){
                Boolean check = true;
                if(a < 2){
                    check = false;
                }
                for(int b = 2; b <= Math.sqrt(a); b++){
                    if(a%b == 0){
                        check = false;
                        break;
                    }
                }
                if(check){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}

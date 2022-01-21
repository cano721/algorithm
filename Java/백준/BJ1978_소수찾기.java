import java.io.*;
import java.util.*;

public class BJ1978_소수찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            Boolean check = true;
            if(num <2){
                continue;
            }
            for(int i = 2; i<= Math.sqrt(num); i++){
                if(num%i == 0){
                    check = false;
                    break;
                }
            }

            if(check){
                cnt += 1;
            }
        }

        System.out.println(cnt);

    }
}


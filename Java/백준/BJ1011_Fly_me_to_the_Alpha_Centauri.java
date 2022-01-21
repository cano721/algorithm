// 실패 다시 풀것


import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BJ1011_Fly_me_to_the_Alpha_Centauri {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int distance = b-a;

            int max = (int)Math.sqrt(distance);

            if(max == Math.sqrt(distance)){
                System.out.println(max*2 -1);
            }else if(distance <= max*max + max){
                System.out.println(max*2);
            }else{
                System.out.println(max*2 +1);
            }
        }

    }
}
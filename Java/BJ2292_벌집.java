import java.io.*;
import java.util.*;

public class BJ2292_벌집 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int answer = 1;
        int cnt = 1;
        while(true){
            if(answer >= a){
                System.out.println(cnt);
                break;
            }
            answer += 6*cnt;
            cnt += 1;
        }
    }
}


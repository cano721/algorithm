import java.io.*;
import java.util.*;

public class BJ10250_ACM호텔 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int floor = n%h;
            if(floor == 0){
                floor = h;
            }
            int room = (int)Math.ceil(n/(double)h);


            System.out.print(floor);
            if (room <10){
                System.out.print(0);
                System.out.println(room);
            }else{
                System.out.println(room);
            }
            
        }
    }
}

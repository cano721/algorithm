import java.io.*;
import java.util.*;

public class BJ1193_분수찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int line = 0;
        int cnt = 0;
        while(cnt < n){
            line++;
            cnt = line*(line+1) / 2;
        }

        if (line % 2 != 0){
            int top = 1 +(cnt-n);
            int bottom = line -(cnt-n);
            System.out.println(top+"/"+bottom);
        }else{
            int top = line -(cnt-n);
            int bottom = 1 +(cnt-n);
            System.out.println(top+"/"+bottom);
        }
            
    }
}

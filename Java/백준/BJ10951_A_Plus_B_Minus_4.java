import java.io.*;
import java.util.StringTokenizer;

public class BJ10951_A_Plus_B_Minus_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            String line = br.readLine();
            if (line == "" || line == null){
                break;
            }else{
                st = new StringTokenizer(line);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                System.out.println(a+b);
            }
        }


    }
}

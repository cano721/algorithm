import java.io.*;
import java.util.StringTokenizer;

public class BJ10952_A_Plus_B_Minus_5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0){
                break;
            }else{
                System.out.println(a+b);
            }
        }


    }
}

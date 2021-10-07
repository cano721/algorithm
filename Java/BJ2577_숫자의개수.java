import java.io.*;
import java.util.Collection;

public class BJ2577_숫자의개수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int num = a*b*c;

        String num2 = String.valueOf(num);

        int [] arr = new int[10];
        for(int i = 0; i < num2.length(); i++){
            arr[(num2.charAt(i)-48)]++;
        }

        for (int v : arr){
            System.out.println(v);
        }

    }
}


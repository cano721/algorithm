import java.io.*;
import java.util.*;

public class BJ11720_숫자의합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += str.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}

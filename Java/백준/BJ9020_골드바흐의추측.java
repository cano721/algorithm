import java.io.*;
import java.util.*;

public class BJ9020_골드바흐의추측 {

    public static int[] arr = new int[10001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        get_prime();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());

            int num1 = n/2;
            int num2 = n/2;

            while(true){
                if(arr[num1] == 0 && arr[num2] == 0){
                    System.out.printf("%d %d\n",num1,num2);
                    break;
                }
                num1--;
                num2++;
            }
        }
    }
    public static void get_prime(){

        for(int a = 2; a < Math.sqrt(arr.length); a++){

            if(arr[a] == 1) continue;

            for(int b = a*a; b < arr.length; b += a){
                arr[b] = 1;
            }
        }
    }

}

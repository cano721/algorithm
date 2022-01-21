import java.io.*;
import java.util.*;

public class BJ1546_평균 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] arr = new int[n];
        double max = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if(max < num){
                max = num;
            }
        }
        double sum = 0.0;
        for(int v : arr){
            sum += v/max*100;
        }
        double answer = sum/n;
        System.out.println(answer);
    }
}

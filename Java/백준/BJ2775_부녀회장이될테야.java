import java.io.*;
import java.util.*;

public class BJ2775_부녀회장이될테야 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[15][15];
            for(int j = 1; j < 15; j++){
                arr[0][j] = j;
                arr[j][1] = 1;
            }
            
            for(int a = 1; a <15; a++){
                for(int b = 2; b < 15; b++){
                    arr[a][b] = arr[a-1][b]+arr[a][b-1];
                }
            }

            System.out.println(arr[k][n]);
        }
    }
}

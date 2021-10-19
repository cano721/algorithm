import java.util.*;
import java.io.*;

public class BJ7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int pnum = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[pnum][2];

        for(int i = 0; i < pnum; i++){
            
            st = new StringTokenizer(br.readLine()," ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        for(int i = 0; i < pnum; i++){
            int answer = 1;

            for(int j = 0; j < pnum; j++){
                if(i == j){
                    continue;
                }

                if(arr[i][0] < arr[j][0]){
                    if(arr[i][1] < arr[j][1]){
                        answer++;
                    }
                }
            }
            System.out.print(answer + " ");
        }
        
    }
}

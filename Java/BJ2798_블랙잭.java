import java.util.*;
import java.io.*;

public class BJ2798_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int cardNum = Integer.parseInt(st.nextToken());
        int wantNum = Integer.parseInt(st.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");


        int[] arr = new int[cardNum];

        for(int i = 0; i < cardNum; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        stop:for(int i = 0; i < cardNum-2; i++){
            for(int j = i+1; j < cardNum-1; j++){
                for(int k = j+1; k < cardNum; k++){
                    int checkNum = arr[i]+arr[j]+arr[k];

                    if(checkNum == wantNum){
                        answer = checkNum;
                        break stop;
                    }else if(checkNum < wantNum && checkNum > answer){
                        answer = checkNum;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

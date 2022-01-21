import java.io.*;
import java.util.*;

public class BJ2108_통계학 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[8001];

        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        int midNum = 0;

        int sum = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            sum+= num;

            arr[num+4000]++;
            if(maxNum < num) maxNum = num;
            if(minNum > num) minNum = num;
        }

        Boolean check = false;
        int cnt = 0;

        int maxCnt= 0;
        int maxCntNum = 0;
        
        for(int j = 0; j < arr.length; j++){
            if(arr[j] >0){
                if(cnt < (n+1)/2){
                    cnt += arr[j];
                    midNum = j-4000;
                }

                if(arr[j] > maxCnt){
                    maxCnt= arr[j];
                    maxCntNum = j-4000;
                    check = true;
                }else if(arr[j] == maxCnt && check){
                    maxCntNum = j-4000;
                    check = false;
                }

            }
        }
        System.out.println(Math.round(sum/(double)n));
        System.out.println(midNum);
        System.out.println(maxCntNum);
        System.out.println(Math.abs(maxNum-minNum));
    }
}

import java.io.*;
import java.util.*;

// 40 30 30 50    40 30 30 20

// 70 100 150      70 100 120
// 70 80  150      70  50 120
// 60 100 150      60  100 120
// 60 110 150      60  80  120

public class BJ11066_파일합치기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k];
            int[] dp = new int[k];
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o1-o2);
            for(int j = 0; j < k; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                pq.offer(num);
            }

            int sum = 0;
            while(pq.size() > 1){
                int num1 = pq.poll();
                int num2 = pq.poll();

                int num3 = num1+num2;
                sum += num3;
                pq.offer(num3);
            }
            int lastNum = pq.poll();
            bw.write(sum + "\n");

            // dp[0] = arr[0];
            // dp[1] = arr[0]+ arr[1];

            // int sum = 0;
            // for(int a = 2; a < k; a++){
            //     dp[a] = Math.min(arr[a]+arr[a-1] + dp[a-2],dp[a-1] +arr[a]);
            // }
            // for(int v : dp){
            //     sum+= v;
            // }

            // bw.write(sum + "\n");
            
        }

        bw.flush();
        bw.close();
    }


}

/**
 * 사람들의 돈 인출 시간이 있는 배열
 * 
 * 적은 순으로 정렬해서 출력
 */

import java.util.*;
import java.io.*;

public class BJ11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            answer += arr[i] + sum;
            sum += arr[i];
        }

        System.out.println(answer);
    }
}
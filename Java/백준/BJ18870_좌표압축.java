import java.io.*;
import java.util.*;

public class BJ18870_좌표압축 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
       for(int i = 0; i < n; i++){
           int num = Integer.parseInt(st.nextToken());
           arr[i] = num;
       }

       int[] sortArr = arr.clone();
       Arrays.sort(sortArr);
       Map<Integer,Integer> maps = new HashMap<>();

       int cnt = 0;
       for(int i = 0; i < n; i++){
           if(maps.get(sortArr[i]) == null){
               maps.put(sortArr[i],cnt++);
           }
       }

       for(int i = 0; i < n; i++){
           bw.write(maps.get(arr[i]) + " ");
       }

       bw.flush();
       bw.close();
    }
}

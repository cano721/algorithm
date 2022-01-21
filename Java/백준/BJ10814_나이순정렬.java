import java.io.*;
import java.util.*;

public class BJ10814_나이순정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        String[][] arr = new String[n][2];

       for(int i = 0; i < n; i++){
           st = new StringTokenizer(br.readLine());

           String age = st.nextToken();
           String name = st.nextToken();
           arr[i][0] = age;
           arr[i][1] = name;
       }

       Arrays.sort(arr,(e1,e2)->{
           Integer age1 = Integer.parseInt(e1[0]);
           Integer age2 = Integer.parseInt(e2[0]);
               return age1-age2;
       });

       for(int i = 0; i < n; i++){
           System.out.println(arr[i][0] + " " + arr[i][1]);
       }
    }
}

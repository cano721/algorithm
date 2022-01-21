import java.io.*;
import java.util.*;

public class BJ1181_단어정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = new String[n];

       for(int i = 0; i < n; i++){
           String word = br.readLine();

           arr[i] = word;
       }

       Arrays.sort(arr,(e1,e2)->{
           if(e1.length() == e2.length()){
               return e1.compareTo(e2);
           }else{
               return e1.length() - e2.length();
           }
       });

       System.out.println(arr[0]);
       for(int i = 1; i < n; i++){
           if(!arr[i].equals(arr[i-1])){
               System.out.println(arr[i]);
           }
       }
    }
}

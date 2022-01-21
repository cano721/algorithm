import java.util.*;
import java.io.*;

public class BJ3052_나머지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            set.add(num%42);
        }
        System.out.println(set.size());
    }
}

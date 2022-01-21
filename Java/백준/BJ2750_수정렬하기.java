import java.io.*;
import java.util.*;

public class BJ2750_수정렬하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            al.add(num);
        }

        al.sort(Comparator.naturalOrder());
        
        for(int v: al){
            bw.write(v + "\n");
        }
        bw.flush();
        bw.close();
    }
}
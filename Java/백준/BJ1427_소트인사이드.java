import java.io.*;
import java.util.*;

public class BJ1427_소트인사이드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n.length(); i++){
            int num  = n.charAt(i)-48;
            al.add(num);
        }

        al.sort(Comparator.reverseOrder());

        for(int i = 0; i < al.size(); i++){
            System.out.print(al.get(i));
        }
    }
}
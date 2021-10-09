import java.io.*;
import java.util.*;

public class BJ10809_알파벳찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alpa = sc.next();

        for(int i = 97; i < 123; i++){
            int idx = alpa.indexOf((char)i);
            System.out.print(idx+" ");
        }
    }
}

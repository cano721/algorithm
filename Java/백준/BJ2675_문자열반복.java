import java.io.*;
import java.util.*;

public class BJ2675_문자열반복 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++){
            int num = sc.nextInt();
            String answer = "";
            String check = sc.next();
            for(int j = 0; j < check.length(); j++){
                for(int k = 0; k < num; k++){
                    answer += check.charAt(j);
                }
            }
            System.out.println(answer);
        }
    }
}

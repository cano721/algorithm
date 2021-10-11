import java.io.*;
import java.util.*;

public class BJ5622_다이얼 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        String a = br.readLine();
        int answer = 0;

        for(int i = 0; i < a.length(); i++){
            int num = a.charAt(i);
            num = (num -65);

            if(num <= 14){
                answer += (num/3)+3;
            }else{
                if(num < 19){
                    answer += 8;
                }else if(num < 22){
                    answer += 9; 
                }else{
                    answer += 10;
                }
            }
            
        }
        System.out.println(answer);
    }
}

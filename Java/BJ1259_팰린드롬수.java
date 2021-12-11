import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ1259_팰린드롬수 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = sc.nextLine();
            boolean check = true;
            if(str.equals("0")){
                break;
            }
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) != str.charAt(str.length()-i-1)){
                    check = false;
                }
            }
            if(check){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

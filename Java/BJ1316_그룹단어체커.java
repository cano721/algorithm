import java.io.*;
import java.util.*;

public class BJ1316_그룹단어체커 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < cnt; i++){
            String a = br.readLine();
            int [] check = new int[26];
            char same = 'A';
            Boolean flag = true;
            for(int j = 0; j < a.length(); j++){
                if(same != a.charAt(j)){
                    if( check[a.charAt(j)-97] == 1){
                        flag = false;
                        break;
                    }
                    same = a.charAt(j);
                    check[a.charAt(j)-97] = 1;
                }
            }
            if(flag){
                answer++;
            }
        }

        System.out.println(answer);
    }
}

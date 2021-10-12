import java.io.*;
import java.util.*;

public class BJ2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        String a = br.readLine();
        int cnt = 0;

        for(int i = 0; i < a.length(); i++){

            char ch = a.charAt(i);

            if(i < a.length()-1){
                if(ch == 'c'){
                    if(a.charAt(i+1) == '='){
                        i++;
                    }else if(a.charAt(i+1) == '-'){
                        i++;
                    }
                }
    
                if(ch == 'd'){
                    if(a.charAt(i+1) == '-'){
                        i++;
                    }else if(i < a.length()-2 && a.charAt(i+1) == 'z' && a.charAt(i+2) == '='){
                        i += 2;
                    }
                }
    
                if(ch == 'l'){
                    if(a.charAt(i+1) == 'j'){
                        i++;
                    }
                }

                if(ch == 'n'){
                    if(a.charAt(i+1) == 'j'){
                        i++;
                    }
                }

                if(ch == 's'){
                    if(a.charAt(i+1) == '='){
                        i++;
                    }
                }

                if(ch == 'z'){
                    if(a.charAt(i+1) == '='){
                        i++;
                    }
                }
            }
            cnt++;
            
        }

        System.out.println(cnt);
    }
}
import java.io.*;

public class BJ1110_더하기사이클 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num = n;
        int cnt = 0;
        while(true){
            if(cnt >0 && num==n){
                System.out.println(cnt);
                break;
            }
            cnt += 1;
            if(num < 10){
                num = num*10 + num;
            }else{
                int newNum = (num%10 + num/10);
                num = (num%10)*10 + newNum%10;
            }
        }
    }
}

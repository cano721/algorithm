import java.io.*;

public class BJ2753_윤년{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        if(year%4 == 0){
            if(year%100 != 0 || year%400 == 0){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
        else{
            System.out.println(0);
        }

    }
}
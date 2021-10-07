import java.io.*;

public class BJ2562_최댓값 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = 0;
        int position = 0;
        for(int i = 0; i < 9; i++){
            int n = Integer.parseInt(br.readLine());
            if (maxNum < n){
                maxNum = n;
                position = i;
            }
        }

        
        System.out.println(maxNum);
        System.out.println(position+1);
    }
}


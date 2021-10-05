import java.io.*;

public class BJ2438_별찍기1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= n; i++){
            bw.write("*".repeat(i) + "\n");
        }
    }
}

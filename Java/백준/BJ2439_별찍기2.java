import java.io.*;

public class BJ2439_별찍기2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= n; i++){
            bw.write(" ".repeat(n-i) + "*".repeat(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

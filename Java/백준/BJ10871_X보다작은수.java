import java.io.*;
import java.util.StringTokenizer;

public class BJ10871_X보다작은수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st2.nextToken());
            if (num < x){
                bw.write(num + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}

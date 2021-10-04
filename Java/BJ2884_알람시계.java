import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2884_알람시계 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (m < 45){
            if (h == 0){
                h = 23;
            }else{
                h = h -1;
            }
            m = m+15;
        }else{
            m = m -45;
        }

        bw.write(h + " " + m + "\n");
        bw.flush();
        bw.close();

    }
}

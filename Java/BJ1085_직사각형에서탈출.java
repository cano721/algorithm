import java.io.*;
import java.util.*;

public class BJ1085_직사각형에서탈출 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int minX = Math.min(a,x-a);
        int minY = Math.min(b,y-b);
        System.out.println(Math.min(minX,minY));

    }
}

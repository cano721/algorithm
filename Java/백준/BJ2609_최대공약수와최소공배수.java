import java.io.*;
import java.util.*;

/**
 * 두개의 자연수를 입력받고
 * 둘중에 작은 숫자에서 내려가면서 둘다 나머지가 0인 숫자 찾기(최대 공약수)
 * 최소공배수: 두 숫자곱 / 최대공약수
 */
public class BJ2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minNum = Math.min(n,m);

        int answer1 = 0;
        long answer2 = 0;
        for(int i = minNum; i > 0; i--){
            if(n%i == 0 && m%i == 0){
                answer1 = i;
                break;
            }
        }

        answer2 = (n*m)/answer1;
        bw.write(answer1 +"\n" + answer2 + "\n");
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

public class BJ4344_평균은넘겠지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //테스트 케이스 수
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i<c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            // 학생 수
            int student = Integer.parseInt(st.nextToken());
            
            // 학생 점수 배열
            int [] arr = new int[student];
            
            // 평균
            double avg = 0;

            // 배열 담기
            for (int j = 0; j <student; j++){
                int v = Integer.parseInt(st.nextToken());
                arr[j] = v;
                avg += v; // 성적 누적합
            }
            
            // 다 더한값 / 학생수
            avg = avg / student;

            // 평균 넘는 학생수 구하기
            double cnt = 0;
            for ( int v : arr){
                if(v > avg){
                    cnt += 1;
                }
            }

            // 퍼센티지로 출력
            double answer = 0;
            answer = cnt/student*100;

            // 셋째자리수까지만 출력
            System.out.println(String.format("%.3f", answer)+"%");


        }
    }
}

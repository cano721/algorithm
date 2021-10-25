import java.io.*;
import java.util.*;

public class BJ1436_영화감독숌 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        // 시작 숫자
        int answer = 665;

        // 666이 들어간 숫자개수
        int temp = 0;

        // 숫자개수가 n과 동일하면 탈출
        while(temp < n){
            //숫자 증가
            answer++;
            
            // 스트링으로 변환후 "666"이 들어가있는지 체크
            if(String.valueOf(answer).contains("666")){
                temp++;
            }
        }
        
        System.out.println(answer);
    }
}

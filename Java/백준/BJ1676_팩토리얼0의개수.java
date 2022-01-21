/**
 * 구현
 * 
 * 0이 만들어질려면 10이 곱해져야함.
 * 
 * 5*2의 배수 개수를 찾고,
 * 그 둘의 개수중 최소치 찾기
 * 
 * ex) 10!
 * 1 2 3 4 5 6 7 8 9 10
 * 
 * 2의배수 5개(2,4,6,8,10) 5의 배수 2개
 * 
 * 무조건 2의배수가 많을 수 밖에 없음.
 * 5의배수만 찾아서 개수를 출력하면 되는데,
 * 이때 5의 승수들은 더 더해줘야함.(25,125...)
 * 
 * while(n>=5){
 *  cnt += n/5;
 *  n/=5;
 * }
 * 
 * 25가 들어갔을때,
 * 25안에 5의 배수들의 개수를 더해주고
 * 25는 5의 승수이므로,5로 나눠서 나머지 더해주기
 * 
 * 125가 들어가도 마찬가지..
 * 
 * 125안의 5의개수 +  == 25
 * 25반환
 * 25안의 5의개수 + == 5
 * 5반환
 * 5+ == 1
 */

import java.util.*;
import java.io.*;

public class BJ1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int five = 0;
        while(n >= 5){
            five += n/5;
            n/=5;
        }
        System.out.println(five);
    }
}

/**
 * 1. 디큐 구현풀이
 * 
 * 2. n개의 명령의 수에 따라 수행
 * 
 * 3. 출력 명령문 마다 출력
 * 
 */

import java.io.*;
import java.util.*;

public class Test {

    public static class Person{
        String name;
        
        public Person(String name){
            this.name = name;
        }

        public void setName(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }

    }
    public static void main(String[] args) {
		Person p = new Person("a");
		System.out.println(p); // 원본변수 p 출력

		createPerson(p); // p의 주소값을 복사하여 createPerson의 매개변수로 전달.
                        // 내부에서 매개변수에 다른 객체의 주소값을 저장하였지만,
                        // 내부에서 쓰는 p와 원본변수의 p는 다른 것이 됨.
                        // 처음엔 주소값이 동일하므로 같은 객체의 프로퍼티에 접근은 가능!
		
        System.out.println(p);

		changeName(p);
		System.out.println(p);

	}  // main의 끝

    public static void createPerson(Person p){
		p = new Person("c");
        System.out.println(p);
	}

	public static void changeName(Person p){
		p.setName("b");
	}
    // public static void main(String[] args) {
    //     // int width = 2;
    //     // int height = 2;
    //     // int[][] diagonals = {{1,1},{2,2}};

    //     int width = 51;
    //     int height = 37;
    //     int[][] diagonals = {{17,19}};
    //     int answer = solution(width, height, diagonals);
    //     System.out.println(answer);
    // }

    // public static int solution(int width, int height, int[][] diagonals) {
    //     int answer = 0;

    //     int div = 10_000_019;
    
    //     long[][] dp = new long[height+1][width+1];
    //     dp[0][0] = 1;

    //     for(int i = 0; i <= height; i++){
    //         for(int j = 0; j <= width; j++){
    //             if(i == 0 & j == 0){
    //                 continue;
    //             }
    //             if(i > 0){
    //                 dp[i][j] += dp[i-1][j];
    //             }
    //             if(j > 0){
    //                 dp[i][j] += dp[i][j-1];
    //             }
    //             dp[i][j]%=div;
    //         }
    //     }

    //     // 대각선 처리
    //     for(int i = 0; i < diagonals.length; i++){
    //         int b = diagonals[i][0];
    //         int a = diagonals[i][1];

    //         long ab = (dp[a][b-1] * dp[height-a+1][width-b])%div;
    //         long ba = (dp[a-1][b] * dp[height-a][width-b+1])%div;

    //         answer += (ab+ba)%div;
    //         answer %= div;
    //     }

    //     return answer;
    // }
}
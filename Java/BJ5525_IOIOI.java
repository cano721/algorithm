/**
 * 문자열 문제
 * 
 * 1) 전체 문자열과 비교할 패턴 문자열이 주어짐
 * 
 * 2) 일반적인 비교를 쓸경우 2중포문으로 문제가 됨
 * 
 * 3) KMP 알고리즘 적용 풀 것
 * 
 */

import java.util.*;
import java.io.*;

public class BJ5525_IOIOI {
    
    public static String all,pattern;
    public static int[] pi;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        all = br.readLine();
        pattern = "I" + "OI".repeat(n);

        pi = new int[pattern.length()];
        
        getPi();
        kmp();
        bw.write(answer +"\n");
        bw.flush();
        bw.close();
    }

    // 패턴 일치 저장 배열
    public static void getPi(){
        int j = 0;
        for(int i = 1; i < pattern.length(); i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                pi[i] = ++j;
            }
        }
    }

    // 패턴 체크 함수
    public static void kmp(){
        
        int j = 0;

        for(int i = 0; i < all.length(); i++){
            while(j > 0 && all.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }

            if(all.charAt(i) == pattern.charAt(j)){
                if(j == pattern.length()-1){
                    answer++;
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }
    }
}

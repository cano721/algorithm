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

    public static void main(String[] args) throws Exception {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        solution(arr);
    }
    public static int[] answer = new int[2];
    
    public static int[] solution(int[][] arr) {
        int[] answer = {};
        
        slice(arr,0,arr.length-1,0,arr[0].length-1);
        
        return answer;
    }
    
    public static void slice(int[][] arr, int si, int ei, int sj, int ej){
        
        if(si == ei || sj == ej){
            int num = arr[si][sj];
            answer[num]++;
            return;
        }
        
        // 전체 같은 숫자로 이루어져있는지 확인
        if(check(arr,si,ei,sj,ej)){
            return;
        }
        
        // 4등분
        slice(arr,si,ei/2,sj,ej/2); // 1사분면
        slice(arr,si,ei/2,ej/2+1,ej); // 2사분면
        slice(arr,ei/2+1,ei,sj,ej/2); // 3사분면
        slice(arr,ei/2+1,ei,ej/2+1,ej); // 4사분면
    }
    
    public static boolean check(int[][] arr, int si, int ei, int sj, int ej){
        
        boolean temp = true;
        int num = arr[si][sj];
        int cnt = 0;
        
        for(int i = si; i <= ei; i++){
            for(int j = sj; j <= ej; j++){
                cnt++;
                if(num != arr[i][j]){
                    temp = false;
                }
            }
        }
        
        if(temp){
            answer[num]++;
        }
        
        return temp;
    }
}
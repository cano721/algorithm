/**
    1. 배열 슬라이싱 복사 (copyOfRange)
    
    2. 정렬
    
    3. 자리수 반환
    
    시간복잡도: commands 50 * 슬라이싱 100
                        50 * 정렬 최대 100*100
**/

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer;
        int n = commands.length;
        answer = new int[n];
        
        for(int i = 0; i < n; i++){
            
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int idx = commands[i][2] -1;
            
            int[] copyArr = Arrays.copyOfRange(array,start,end);
            
            Arrays.sort(copyArr);
            
            answer[i] = copyArr[idx];
        }
        
        return answer;
    }
}
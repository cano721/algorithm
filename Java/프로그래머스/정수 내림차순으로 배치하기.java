/**
    1. 각 자리수 정렬
**/

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] strs = (n+ "").split("");
        
        Arrays.sort(strs,Collections.reverseOrder());
        
        String str = String.join("",strs);
        answer = Long.parseLong(str);
        return answer;
    }
}
/**
    1. char 기준으로 정렬
    
**/

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder(new String(c));
        answer = sb.reverse().toString();
        return answer;
    }
}
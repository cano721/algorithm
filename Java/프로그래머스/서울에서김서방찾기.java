/**
    1. 문자열 내 위치 찾기
**/

import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int idx = 9;
        
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                idx = i;
                break;
            }
        }
        
        answer = "김서방은 " +idx + "에 있a다";
        return answer;
    }
}
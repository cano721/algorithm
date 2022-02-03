/**
    1. n을 3진법 변환
    
    2. 해당 3진법 리버스
    2-1) 변환과정을 스트링빌더로 담으면 반대순서가 됨
    
    3. 10진법으로 다시 변환 후 반환
**/

import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        
        StringBuffer sb = new StringBuffer();
        
        while(n >0){
            sb.append(n%3);
            n/=3;
        }
        String str = sb.toString();
        
        return Integer.parseInt(str,3);
    }
}
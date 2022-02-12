/**
    1. 각 자리수 더하기
**/

import java.util.*;

class Solution {
    int solution(int n) {
        int answer = 0;

        while(n > 0){
            answer += n%10;
            n/=10;
        }

        return answer;
    }
}
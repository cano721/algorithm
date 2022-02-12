/**
    1. 스트링빌더로 뒤집기
    2. 인트 배열 변환 반환
**/

import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(long n) {
        
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        
        String str = sb.reverse().toString();
        int[] answer = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
        return answer;
    }
}
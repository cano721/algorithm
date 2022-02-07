/**
    1. 단어별 홀수 짝수 인덱스 변환
    
    2. 강제 형변환 사용
**/

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        for(int i = 0; i < s.length();i++){
            
            char c = s.charAt(i);
            
            idx = c == ' ' ? 0 : idx+1;
            
            answer += idx%2 == 1? Character.toUpperCase(c) : Character.toLowerCase(c);
        }
        
        return answer;
    }
}
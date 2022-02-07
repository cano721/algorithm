/**
    1. 문자열 길이 체크
    
    2. 문자열 숫자여부 체크
**/
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6){
            answer = false;
        }
        
        if(!s.matches("[0-9]*")){
            answer = false;
        }
        return answer;
    }
}
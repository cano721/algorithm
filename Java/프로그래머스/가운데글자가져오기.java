/**
    1. length의 절반에 해당하는 idx글자 반환
    
    2. 짝수면 절반-1,절반 반환
**/

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int len = s.length();
        
        if(len% 2 == 0){
            answer = s.substring(len/2-1,len/2+1);
        }else{
            answer = s.substring(len/2,len/2+1);
        }
        return answer;
    }
}
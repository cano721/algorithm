/**
    1. 문자열 반복
**/

class Solution {
    public String solution(int n) {
        String answer = "";
        
        String str = "수박";
        String str2 = "수";
        
        if(n% 2 == 0){
            answer += str.repeat(n/2);
        }else{
            answer += str.repeat(n/2)+str2;
        }
        
        
        return answer;
    }
}
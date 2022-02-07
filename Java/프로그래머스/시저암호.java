/**
    1. 아스키코드 이용 문제풀이
**/

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i);
            
            if(s.charAt(i) == ' '){
                answer += s.charAt(i) +"";
            }else{
                if(num >= 65 && num <=90){
                    if(num+n > 'Z') num -= 26;
                }else{
                    if(num+n > 'z') num -= 26;
                }
                num +=n;
                answer += (char)num +"";   
            }
        }
        return answer;
    }
}
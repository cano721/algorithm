/**
    1. 대문자로 변경후 카운트
**/

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int p = 0;
        int y = 0;
        
        s = s.toUpperCase();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'P'){
                p++;
            }else if(c == 'Y'){
                y++;
            }
        }
        if(p != y){
            answer = false;
        }

        return answer;
    }
}
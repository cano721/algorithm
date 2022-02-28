/**
    1. 구현
    
**/

class Solution {
    public int solution(int num) {
        int answer = 0;
        
        long lnum = (long)num;
        while(lnum != 1){
            
            if(answer == 500){
                return -1;
            }
            
            lnum = (lnum%2 == 0) ? lnum/2 : lnum*3+1;
            answer++;
        }
        
        return answer;
    }
}
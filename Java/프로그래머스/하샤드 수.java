/**
    1.구현
**/

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int checkNum = 0;
        int nx = x;
        
        while(nx > 0){
            checkNum += nx%10;
            nx/=10;
        }
        
        if(x%checkNum != 0){
            answer = false;
        }
        return answer;
    }
}
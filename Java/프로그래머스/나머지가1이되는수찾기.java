/**
    1. for문을 이용해서 x를 정한 후 나머지 1이면 리턴
    
**/

class Solution {
    public int solution(int n) {
        
        for(int i = 2; i < n; i++){
            
            if(n%i == 1){
                return i;
            }
        }
        
        return 0;
    }
}
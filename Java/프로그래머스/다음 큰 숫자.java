/**
    1. n증가시키면서 켜진 비트수가 동일할 때 출력
        
**/

class Solution {
    public int solution(int n) {
        int num = Integer.bitCount(n);
        
        while(true){
            n++;
            if(num == Integer.bitCount(n)){
                break;
            }
        }
        
        return n;
    }
}
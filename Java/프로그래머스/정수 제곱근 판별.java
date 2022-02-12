/**
    1.제곱근이 정수면 +1의 제곱 반환
    
    2. 아니면 -1반환
**/

class Solution {
    public long solution(long n) {
        
        if(Math.sqrt(n)%1 > 0){
            return -1;
        }else{
            return (long)Math.pow(Math.sqrt(n)+1,2);
        }
    }
}
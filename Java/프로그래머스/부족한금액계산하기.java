/**
    1. count에 따른 놀이기구 비용 계산
    
    2. 계산된 비용에서 가진 비용 뺀 것을 리턴
    
    3. 뺀 금액이 음수면 0으로 리턴
    
**/

class Solution {
    public long solution(int price, int money, int count) {
        
        long pay = 0;
        for(int i = 1; i <= count; i++){
            pay += (long)price*i;
        }
        
        pay -= money;
        
        if(pay <= 0){
            return 0;
        }else{
            return pay;
        }
    }
}
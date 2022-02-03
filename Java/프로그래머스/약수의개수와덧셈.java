/**
    1. left~right 돌기
    
    2. 현재 숫자를 현재숫자이하로 나누기
    
    3. 나눠서 0으로 떨어지는 수가 짝수면 result에 현재 수를 더하고 아니면 빼기
    
    4. 최종 반환
**/

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <=right; i++){
            int cnt = 0;
            for(int j = 1; j <= i; j++){
                if(i%j == 0) cnt++;
            }
            if(cnt%2 == 0){
                answer+= i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}
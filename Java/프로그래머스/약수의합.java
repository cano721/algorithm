/**
    1. n이하 돌면서 나눠서 0이되는 값 더하기
**/

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n/2; i++){
            if(n%i == 0){
                answer+= i;
            }
        }
        answer+=n;
        return answer;
    }
}
/**
    1. 구현
**/

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for(int i = 1; i <= n; i++){
            long num = (long)x*i;
            answer[i-1] = num;
        }
        return answer;
    }
}
/**
    1000*1000*1000 = 10^9?? 10억이여서 안벗어남.
**/
class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i = 0; i < a.length; i++){
            answer += a[i] * b[i];
        }
        return answer;
    }
}
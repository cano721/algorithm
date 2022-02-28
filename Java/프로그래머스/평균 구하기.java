/**
    1. 평균값 반환
**/

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        int sum = 0;
        
        for(int v: arr){
            sum+= v;
        }
        answer = (double)sum / arr.length;
        return answer;
    }
}
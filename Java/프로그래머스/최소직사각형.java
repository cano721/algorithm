/**
    1. 가로 세로 중 큰것을 큰것과 비교, 작은것을 작은것과 비교
    
    2. 최종 정해진 큰길이와 작은길이를 곱해서 정답 반환
**/

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max = 0;
        int min = 0;
        
        for(int[] size : sizes){
            int a = size[0];
            int b = size[1];
            
            max = Math.max(max,Math.max(a,b));
            min = Math.max(min,Math.min(a,b));
        }
        answer = max*min;
        return answer;
    }
}
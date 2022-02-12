/**
    1. 가장 작은 수 제거 배열 리턴
**/

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1){
            return new int[] {-1};
        }
        
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                idx = i;
            }
        }
        
        int[] answer = new int[arr.length-1];
        
        int ansIdx= 0;
        for(int i = 0; i < arr.length;i++){
            if(i != idx){
                answer[ansIdx++] = arr[i];
            }
        }
        
        return answer;
    }
}
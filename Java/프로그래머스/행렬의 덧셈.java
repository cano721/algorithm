/**
    1. 구현
**/

class Solution {
    
    public int[][] answer;
    public int[][] solution(int[][] arr1, int[][] arr2) {
        answer = new int[arr1.length][arr1[0].length];
        
        sumArr(arr1);
        sumArr(arr2);
        
        return answer;
    }
    
    public void sumArr(int[][] arr){
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                answer[i][j] += arr[i][j];
            }
        }
    }
}
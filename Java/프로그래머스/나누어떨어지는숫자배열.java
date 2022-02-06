/**
    1. 정렬 후 나눠지는 원소를 어레이리스트에 저장
    
    2. 배열로 반환
**/

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for(int v: arr){
            if(v % divisor == 0){
                arrList.add(v);
            }
        }
        
        if(arrList.size() == 0){
            int[] answer = {-1};
            return answer;
        }else{
            int[] answer = new int[arrList.size()];
            for(int i = 0; i < arrList.size(); i++){
                answer[i] = arrList.get(i);
            }
            return answer;
        }
    }
}
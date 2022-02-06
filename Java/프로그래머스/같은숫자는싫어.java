/**
    1. 과거의 숫자를 저장해두고 비교하기
    
    2. arrayList에 넣기
    
    3. 배열로 반환
**/

import java.util.*;

class Solution {
    int[] solution(int []arr) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        int pnum = -1;
        for(int v: arr){
            if(pnum != v){
                arrList.add(v);
            }
            pnum = v;
        }
        
        int[] answer = new int[arrList.size()];
        
        for(int i = 0; i < arrList.size(); i++){
            answer[i] = arrList.get(i);
        }

        return answer;
    }
}
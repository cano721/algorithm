/**
    1. 구현..
    
    2. i행 i열까지 모든 숫자를 i로 채운다는 것은
        행과 열중에 높은 숫자가 들어간다는 것.
        즉 2,3 이면 더 높은 숫자인 3으로 채워져 있고,
        5,3 이면 더 높은 숫자인 5로 들어가져 있음.
        
        1 2 3
        2 2 3
        3 3 3
    
    3. 2차원 배열을 모두 이어붙인 1차원 배열에서 left~right만 반환
       1차원 배열의 해당 인덱스는 행과 열로 나누면
       인덱스/n이 행이 되고 인덱스%n이 열이 되는데,
       1부터 시작이므로 +1씩 해준다.
       
    4. 해당하는 숫자들을 담은 어레이리스트를 인트배열로 반환
**/

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(long i = left ; i <= right; i++){
            int h = (int)(i / n);
            int w = (int)(i%n);
            
            if(h>w){
                answer.add(h+1);
            }else{
                answer.add(w+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
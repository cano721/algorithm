/**
    1. 스택을 이용한 풀이
    
    2. 문자열을 탐색하면서 해당 문자와 스택에 담긴 문자가 같을때, 스택에서 pop 아니면 스택에 push
    
    3. 최종 스택에 담긴 문자열이 있으면 0반환 없으면 1반환
**/

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        return stack.isEmpty()? 1:0;
    }
}
/**
    2차원 배열로 인형담겨 있는 게임화면 배열 만들기
    스택으로 바구니 형성
    
    시간복잡도: 1000*30
    1. moves의 크레임 움직임에 따라 2차원 배열에서 인형뽑기
    1-1) 무브로 행 고정(-1)
    1-2) 열은 0이 아닐때까지 증가하여 인형 찾기
    2. 인형뽑았을때, 스택(바구니)의 맨위 원소 비교
    
    3. 같으면 사라진 인형 증가 +2
    
    4. 다르면 스택에 담기
    
    5. 기존 게임의 인형은 없애기
    
    6. 최종 결과 출력
**/

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < moves.length; i++){
            int w = moves[i]-1;
            int h = 0;
            // 인형이 보일때까지 열 증가
            while(h < board[0].length-1 && board[h][w] == 0){
                h++;
            }
            // 다 확인했는데도 인형이 없으면 다음 크레인 움직임 확인
            if(board[h][w] == 0){
                continue;
            }
            // 바구니가 안비어있으면서 인형이 바구니 맨위랑 같으면
            if(!stack.isEmpty() && board[h][w] == stack.peek()){
                answer+=2;
                stack.pop();
            // 아니면 바구니에 집어넣기
            }else{
                stack.add(board[h][w]);
            }
            board[h][w] = 0;
        }
        return answer;
    }
}
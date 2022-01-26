/**
    1. 1~3번 수포자의 찍는 방식 패턴 저장
    
    2. 문제를 돌면서 정답 맞춘 개수 배열에 저장
    
    3. 가장 많이 맞춘사람 리스트에 넣고 배열로 반환
    
    
**/

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] check = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            
            int aIdx = i%a.length;
            int bIdx = i%b.length;
            int cIdx = i%c.length;
            
            if(answers[i] == a[aIdx]){
                check[0]++;
            }
            if(answers[i] == b[bIdx]){
                check[1]++;
            }
            if(answers[i] == c[cIdx]){
                check[2]++;
            }
        }
        
        int max = 0;
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(check[i] > max){
                max = check[i];
                answerList.clear();
                answerList.add(i+1);
            }else if(check[i] == max){
                answerList.add(i+1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        int idx = 0;
        for(int v: answerList){
            answer[idx++] = v;
        }
        
        return answer;
    }
}
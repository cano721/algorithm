/**
    실패율 : 스테이지 도달 o 성공 x / 스테이지 도달 o
            해당 스테이지 사용자 / 해당스테이지 <= 사용자
       
    1. 사용자들을 스테이지별로 저장(해쉬맵 사용) 최대 500개 생성
    
    2. 스테이지를 돌면서 실패율 계산 및 우선순위큐에 넣기
    500*500
    
    3. 우선순위큐를 실패율 기준으로 내림차순으로 하여 뽑기
    
    4. 뽑은 스테이지를 정답 배열에 넣기 
    
    5. 정답 배열 반환
    
**/

import java.util.*;

class Solution {
    
    public class Fail implements Comparable<Fail>{
        int num;
        double fail;
        
        public Fail(int num, double fail){
            this.num = num;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Fail o){
            if(this.fail > o.fail){
                return -1;
            }else if(this.fail < o.fail){
                return 1;
            }else{
                if(this.num > o.num){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer,Double> map = new HashMap<>();
        
        for(int v: stages){
            map.put(v,map.getOrDefault(v,0d)+1);
        }
        
        
        PriorityQueue<Fail> q = new PriorityQueue<>();
        
        
        for(int i = 1; i <= N; i++){
            int a = 0;
            int b = 0;
            for(int j : map.keySet()){
                if(i == j){
                    a += map.get(j);
                }
                if(i <= j){
                    b += map.get(j);
                }
            }
            if(b == 0 || a == 0){
                q.offer(new Fail(i,0d));
            }else{
                q.offer(new Fail(i,a/(double)b));
            }
        }
        
        int idx = 0;
        
        while(!q.isEmpty()){
            Fail cur = q.poll();
            
            answer[idx++] = cur.num;
        }
        
        return answer;
    }
}
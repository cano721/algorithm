/**
    참여 마라톤 선수를 해시맵에 넣고,
    완주한 선수들은 맵에서 지우기
    
    
    해시맵에 남은 선수 반환

    동명이인 처리 주의
**/

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> map = new HashMap<>();
        
        for(String v: participant){
            map.put(v,map.getOrDefault(v,0)+1);
        }
        for(String v: completion){
            if(map.get(v) > 1){
                map.put(v,map.get(v)-1);
            }else{
                map.remove(v);
            }
        }
        
        for(String v: map.keySet()){
            answer = v;
        }
        
        return answer;
    }
}
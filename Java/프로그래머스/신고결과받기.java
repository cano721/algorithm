/**
    1. 유저 리스트, 신고 리스트, k번 신고 유저 정지
    1-1) 유저 최대 1000, 신고 리스트 최대 200,000
    
    2. 신고 내역을 기준으로 몇번 신고했는지 체크
    2-1) 인트배열로 각 이름별 신고 체크
    2-2) 한명이 동일사람에게 여러번 체크해도 1회 체크해야하므로,
        신고했었다면 다음번은 무시처리하게 2차원 배열로 신고여부 확인
    2-3) 이름별 idx 해시 생성하여 배열체크할때 쓸것
    
    3. 신고횟수 배열을 돌며 k를 넘었을때,
        2차원 신고여부 배열을 돌며 해당사람을 신고했었다면,
        정답배열에 +1 증가
    
**/

import java.util.*;

class Solution {
    
    public boolean[][] check;
    public int[] reportNum, answer;
    public Map<String,Integer> name = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 해시 생성
        create_name(id_list);
        
        // 신고 체크
        check = new boolean[id_list.length][id_list.length];
        reportNum = new int[id_list.length];
        check_report(report);
        
        // 정답 생성
        answer = new int[id_list.length];
        make_answer(k);
        
        return answer;
    }
    
    public void make_answer(int k){
        for(int i = 0; i < reportNum.length; i++){
            if(reportNum[i] >= k){
                for(int j = 0; j < reportNum.length; j++){
                    if(check[j][i] == true){
                        answer[j]++;
                    }
                }
            }
        }
    }
    
    public void check_report(String[] report){
        for(int i = 0; i < report.length; i++){
            String[] people = report[i].split(" ");
            String p1 = people[0];
            String p2 = people[1];
            
            if(check[name.get(p1)][name.get(p2)] == false){
                check[name.get(p1)][name.get(p2)] = true;
                reportNum[name.get(p2)]++;
            }
        }
    }
    
    public void create_name(String[] id_list){
        for(int i = 0; i < id_list.length; i++){
            name.put(id_list[i],i);
        }
    }
}
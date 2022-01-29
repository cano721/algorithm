/**
    1. 루트노드 출발, dfs로 구현
    
    2. edges를 가보기
    
    3. 방문한곳은 -1로 처리
    
    4. 방문할때마다 최대 양의 수 저장
    
    5. 중간에 늑대의수가 같아지면 탈출

    6. 반복은 visited로 제거

**/

import java.util.*;

class Solution {
    public ArrayList<Integer>[] graphs;
    public boolean[][][] visited;
    public int answer = 1;
    public int[] infos;
    
    public int solution(int[] info, int[][] edges) {
        graphs = new ArrayList[info.length];
        
        for(int i = 0; i < info.length; i++){
            graphs[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            // 양방향 이동 가능
            graphs[edge[0]].add(edge[1]);
            graphs[edge[1]].add(edge[0]);
        }
        
        visited = new boolean[info.length][info.length+1][info.length+1];
        infos = info;
        visited[0][0][0] = true;
        dfs(0,0,0);
        return answer;
    }
    
    public void dfs(int idx, int sheep, int wolf){
        
        int temp = -1;
        // 현재 온곳이 빈곳이 아니면
        if(infos[idx] != -1){
            if(infos[idx] == 0){
                temp = 0;
                sheep++;
            }else{
                temp = 1;
                wolf++;
            }
        }
        
        // 늑대가 더많거나 같으면 종료
        if(sheep <= wolf){
            return;
        }else{
            answer = Math.max(answer,sheep);
        }
        
        // 다음 곳 가보기
        for(int i = 0; i < graphs[idx].size(); i++){
            int next = graphs[idx].get(i);
            // 이상태로 가본적 있으면 패스
            if(visited[next][sheep][wolf] == true){
                continue;
            }
            // 현재 있던곳은 빈곳으로 처리
            infos[idx] = -1;
            // 이상태로 한번 온것으로 처리
            visited[idx][sheep][wolf] = true;
            dfs(next,sheep,wolf);
            // 다시 되돌리기
            infos[idx] = temp;
            visited[idx][sheep][wolf] = false;
        }
    }
}
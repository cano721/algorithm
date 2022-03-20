/**
    1. 정점 100 간선 99
    
    2. 간선마다 끊어서 확인..? (99 * )
    
    3. 체크함수 bfs? n 100
**/

import java.util.*;

class Solution {
    
    public ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int[] wire: wires){
            answer = Math.min(answer,wireCut(wire));
        }
        
        return answer;
    }
    
    public int wireCut(int[] wire){
        
        int a = wire[0];
        int b = wire[1];
        
        int cntA = bfs(a,b);
        int cntB = bfs(b,a);
        
        return Math.abs(cntA-cntB);
    }
    
    public int bfs(int node, int cutNode){
        
        boolean[] visited = new boolean[graph.length];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        
        int cnt = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph[cur]){
                if(visited[next] == false && next != cutNode){
                    visited[next] = true;
                    q.offer(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
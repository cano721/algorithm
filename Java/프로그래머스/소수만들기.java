/**
    1. 숫자 3개 선택
    1-1) 백트래킹으로 선택 1000C3
    1-2) 고른갯수, 합계,현재고른 idx, 배열.
        다음번 for문은 현재고른 idx+1부터 시작하여 중복제거.
    
    
    2. 선택한 숫자들의 합이 소수인지 판별
    1-1) 시간복잡도 최악 루트 2998 == 3.xx
    
    3. 소수이면 answer++;
    
    4. 최종 출력
**/

class Solution {
    
    public int answer = 0;
    public boolean[] visited;
    public int solution(int[] nums) {
        
        visited = new boolean[nums.length];
        solve(0,0,-1,nums);

        return answer;
    }
    
    public void solve(int stage, int sum,int pidx, int[] nums){
        
        if(stage == 3){
            if(prime(sum)){
                answer++;
            }
            return;
        }
        
        for(int i = pidx+1; i < nums.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                solve(stage+1,sum+nums[i],i,nums);
                visited[i] = false;
            }
        }
    }
    
    public boolean prime(int num){
        
        if(num < 2) return false;
        
        if(num == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
/**
    1. 에라토스테네스의 체 
**/

class Solution {
    
    public boolean[] p;
    
    public int solution(int n) {
        int answer = 0;
        
        prime(n);
        
        for(int i = 1; i <= n; i++){
            if(p[i] == false){
                answer++;
            }
        }
        return answer;
    }
    
    public void prime(int n){
        
        p = new boolean[n+1];
        
        if(n < 2){
            return;
        }
        
        p[0] = p[1] = true;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            
            if(p[i] == true) continue;
            
            for(int j = i*i; j < p.length; j+=i){
                p[j] = true;
            }
        }
    }
}
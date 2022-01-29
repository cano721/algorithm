/**
    누적합 개념 적용
    
    1. 해당 스킬이 들어올때, 범위 시작부에 더해놓고, 범위 끝+1 범위에 빼두기
    
    2. 누적합 배열 돌면서, 해당 앞의 값을 더해가기( 누적된 증감 값을 담아두기)
    
    3. 해당 누적값 적용하여 남은 건물 개수 체크
    
    
**/
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n+1][m+1];
        
        for(int[] s: skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            
            int degree = (type == 1) ? -s[5] : s[5];
            
            for(int i = r1; i<=r2; i++){
                sum[i][c1] += degree;
                sum[i][c2+1] -= degree;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(j != 0) sum[i][j] += sum[i][j-1];
                board[i][j] += sum[i][j];
                if(board[i][j] > 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
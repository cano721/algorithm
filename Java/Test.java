import java.util.*;

public class Test {

    public static int a,b;
    public static int[] dirX = {0,0,1,-1};
    public static int[] dirY = {1,-1,0,0};
    public static int[][] grid;
    public static int size,cnt;
    public static Boolean boolMarum;

    public static void main(String[] args) {
        // grid = new int[][] {{2,1,1,3,5,1},{1,1,3,3,5,5},{8,3,3,3,1,5},{3,3,3,4,4,4},{3,3,4,4,4,4},{1,4,4,4,4,4}};
        grid = new int[][] {{10,20,30},{40,50,60},{70,80,90}};
        solution(grid);
    }
    public static void solution(int[][] grid) {
        int[] answer = {};
        a = grid.length;
        b = grid[0].length;
        boolMarum = false;
        size = 1;
        cnt = a*b;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                bfs(i,j);
            }
        }
        System.out.println("["+ size + "," + cnt + "]");
    }

    public static void bfs(int x,int y){
        int[][] visited = new int[a][b];

        // 현재 찾는 숫자
        int number = grid[x][y];

        // 그 숫자로 비지티드를 채워서 마름모체크 함수로 넘길거임
        visited[x][y] = number;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int num = 0; num < 4; num++){
                int newX = cur[0] + dirX[num];
                int newY = cur[1] + dirY[num];
                // 맵 안에 있는지 체크, 방문안했는지 체크
                if(0 <= newX && newX < a && 0 <= newY && newY < b && visited[newX][newY] == 0){
                    // 같은 숫자인지 체크
                    if(grid[newX][newY] == number){
                        visited[newX][newY] = number;
                        q.offer(new int[] {newX,newY});
                    }
                }
            }
        }
        check(visited,number);
    }

    public static void check(int[][] visited, int number){
        // 마름모 최대 크기
        int maxNum = Math.min(a,b);
        int[][][] marum = {{{0,1},{1,0},{1,-1}},{{0,-1},{1,0},{1,1}},{{-1,0},{0,1},{1,1}},{{-1,0},{0,-1},{1,-1}}};
        while(maxNum >= size){
            end :for(int ci = 0; ci < a; ci++){
                for(int cj = 0; cj < b; cj++){
                    // 0이 아니라면
                    if(visited[ci][cj] != 0){
                        //4방향 마름모 확인
                        for(int[][] v1 : marum){
                            Boolean bool = true;
                            // 각 비교
                            for(int[] v2: v1){
                                int checkNum = maxNum -1;
                                while(checkNum > 1){
                                    int newCi = ci+ v2[0]*checkNum;
                                    int newCj = cj + v2[1]*checkNum;
                                    if(0 <= newCi && newCi < a && 0 <= newCj && newCj < b && visited[newCi][newCj] == number){
                                        continue;
                                    }else bool = false;
                                }
                                    
                            }
                            // 마름모가 맞으면
                            if(bool){
                                if(maxNum > size){
                                    size = maxNum;
                                    cnt = 1;
                                }else cnt++;
                                break end;
                            }
                        }

                    }
                }
            }
            maxNum--;
        }
    }
}

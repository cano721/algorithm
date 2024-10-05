import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 학교 크기 N*M
 * <p>
 * 도연 이동방향 상하좌우
 * <p>
 * 만날 수 있는 사람의 수 출력.
 * <p>
 * bfs, dfs
 * <p>
 * 시간 복잡도 n*m ( 맵 만들어야해서 )
 * <p>
 * n 최대 600
 * m 최대 600
 * <p>
 * n*m 맵 생성 후 입력값 기반 공간 별 무엇이 있는지 처리
 * O 빈공간 X 벽 I 도연 P 사람
 * <p>
 * I 주어질 때, 시작 위치 저장.
 * <p>
 * I 기반 가볼 수 있는 곳들 이동 후 방문처리. (DFS 스택. BFS 큐 )
 * <p>
 * 최종 갈 곳이 없을 때, 만난 사람 수 출력. ( 없을 경우, TT )
 */
public class Main {

    public static int answer = 0;
    public static int[][] direction = new int[][]{{1,0},{0,1},{-1,0}, {0,-1}};
    public static int n = 0;
    public static int m = 0;
    public static int[][] visited;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        int startX = 0;
        int startY = 0;

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String mapDetail = bufferedReader.readLine();

            for (int j = 0; j < mapDetail.length(); j++) {
                char c = mapDetail.charAt(j);

                if (c == 'I') {
                    startX = i;
                    startY = j;
                    visited[i][j] = 1;
                } else if (c == 'P') {
                    map[i][j] = 2;
                } else if (c == 'O') {
                    map[i][j] = 0;
                } else if (c == 'X') {
                    map[i][j] = 1;
                }
            }
        }

//        dfs(startX, startY);
        bfs(startX, startY);

        if(answer == 0){
            bufferedWriter.write("TT");
        } else {
            bufferedWriter.write(String.valueOf(answer));
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int[] ints : direction) {
                int newX = ints[0] + x;
                int newY = ints[1] + y;

                // 맵 범위 벗어남
                if(newX < 0 || newX >= n || newY < 0 || newY >= m){
                    continue;
                }

                // 이미 방문한 곳 또는 벽
                if(visited[newX][newY] == 1 || map[newX][newY] == 1) {
                    continue;
                }

                visited[newX][newY] = 1;

                if(map[newX][newY] == 2){
                    answer++;
                    queue.add(new int[]{newX, newY});
                }

                if(map[newX][newY] == 0){
                    queue.add(new int[]{newX, newY});
                }

            }
        }
    }

    private static void dfs(int x, int y) {
        for (int[] ints : direction) {
            int newX = ints[0] + x;
            int newY = ints[1] + y;

            // 맵 범위 벗어남
            if(newX < 0 || newX >= n || newY < 0 || newY >= m){
                continue;
            }

            // 이미 방문한 곳 또는 벽
            if(visited[newX][newY] == 1 || map[newX][newY] == 1) {
                continue;
            }

            visited[newX][newY] = 1;

            if(map[newX][newY] == 2){
                answer++;
                dfs(newX, newY);
            }

            if(map[newX][newY] == 0){
                dfs(newX, newY);
            }
        }
    }
}
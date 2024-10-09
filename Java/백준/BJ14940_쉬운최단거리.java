import java.util.*;

/**
 * 맵의 크기 n*m ( 2 <= n,m <= 1000)
 *
 * 각 지점까지의 최단거리 구하기
 *
 * bfs로 풀이
 */
public class Main {

    static int[] dx = {0, 0, 1, -1};  // 상하좌우 이동을 위한 x좌표 변화량
    static int[] dy = {1, -1, 0, 0};  // 상하좌우 이동을 위한 y좌표 변화량

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        init(sc, n, m, map, dist, visited, queue);

        bfs(n, m, map, dist, visited, queue);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void bfs(int n, int m, int[][] map, int[][] dist, boolean[][] visited, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 유효한 범위 내에 있고, 아직 방문하지 않은 갈 수 있는 땅이면
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;  // 최단 거리 갱신
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static void init(Scanner sc, int n, int m, int[][] map, int[][] dist, boolean[][] visited, Queue<int[]> queue) {
        int goalX = -1, goalY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    goalX = i;
                    goalY = j;
                    dist[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                } else if (map[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }
    }
}

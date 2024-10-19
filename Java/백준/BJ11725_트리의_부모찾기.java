import java.util.ArrayList;
import java.util.List;

/**
 * 링크드 리스트로 주어진 간선 연결
 *
 * dfs나 bfs로 탐색하여 출력 풀이
 *
 * 시간복잡도 : O(V+E) V는 정점의 개수, E는 간선의 개수
 * V <= 100,000 E <= 100,000-1
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int N = scanner.nextInt();

        List<Integer>[] tree = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            tree[a].add(b);
            tree[b].add(a);
        }

        int[] parent = bfs(tree, 1, N);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static int[] bfs(List<Integer>[] tree, int root, int nodeCount) {

        int[] parent = new int[nodeCount+1];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(root);
        parent[root] = 1;

        while (!queue.isEmpty()){
            int current = queue.poll();

            for(int next : tree[current]){
                if(parent[next] == 0){
                    parent[next] = current;
                    queue.offer(next);
                }
            }
        }
        return parent;
    }
}
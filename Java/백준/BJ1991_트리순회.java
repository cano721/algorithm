import java.util.HashMap;
import java.util.Map;

/**
 * 재귀 풀이
 */
public class Main {
    public static Map<String, Node> tree = new HashMap<>();

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++){
            String root = scanner.next();
            String left = scanner.next();
            String right = scanner.next();
            tree.put(root, new Node(left, right));
        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    private static void preOrder(String root) {
        if(root.equals(".")){
            return;
        }
        System.out.print(root);
        preOrder(tree.get(root).left);
        preOrder(tree.get(root).right);
    }

    private static void inOrder(String root) {
        if(root.equals(".")){
            return;
        }
        inOrder(tree.get(root).left);
        System.out.print(root);
        inOrder(tree.get(root).right);
    }

    private static void postOrder(String root) {
        if(root.equals(".")){
            return;
        }
        postOrder(tree.get(root).left);
        postOrder(tree.get(root).right);
        System.out.print(root);
    }

    public static class Node {
        String left;
        String right;

        public Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }
}
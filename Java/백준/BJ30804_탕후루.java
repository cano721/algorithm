import java.util.*;

/**
 * 특정 조건의 구간의 합 구하기
 *
 * 슬라이딩 윈도우 기법 O(N)
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int N = scanner.nextInt();
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = scanner.nextInt();
        }

        Map<Integer, Integer> count = new HashMap<>();
        int maxLen = 0, start = 0;

        for (int end = 0; end < N; end++) {
            count.put(fruits[end], count.getOrDefault(fruits[end], 0) + 1);
            if(count.size() > 2) {
                count.put(fruits[start], count.get(fruits[start]) - 1);
                if (count.get(fruits[start]) == 0) {
                    count.remove(fruits[start]);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        System.out.println(maxLen);
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * default 0
 *
 * 절사평균 : 데이터에서 일부를 제외하고 평균을 구하는 방법
 *
 * 30% 절사평균 시 상위 15%, 하위15% 제외 후 평균 구하기
 *
 * 제외되는 사람 수는 반올림.
 *
 * 마지막 계산된 평균도 정수로 반올림.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Integer> levelList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int level = Integer.parseInt(bufferedReader.readLine());
            levelList.add(level);
        }

        levelList.sort(Comparator.naturalOrder());

        int removeCount = (int) Math.round(n * 0.15);

        List<Integer> subList = levelList.subList(removeCount, n - removeCount);

        // levelList 원소값 다 더하기
        int sum = 0;
        for (int i : subList) {
            sum += i;
        }

        int divideNum = n - (2 * removeCount);

        int answer = Math.round((float) sum / divideNum);
        bufferedWriter.write(String.valueOf(answer));

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
import java.io.*;
import java.util.Arrays;


/**
 * 참가자 수 N
 * 티셔츠 묶음 T
 * 펜의 묶음 P
 *
 * 신청 사이즈에 맞게 티셔츠 제공
 * 티셔츠는 남아도 됨
 * 펜은 남으면 안됨
 *
 * 티셔츠는 묶음단위 주문 가능
 * 펜은 묶음 또는 1개단위로 주문 가능
 *
 * 티셔츠부터 T묶음 단위 주문 시 몇번 주문 넣어야하는지 체크 ( /T)
 * 펜은 T 묶음 단위 주문 후 나머지 값 까지 구하기 ( /P 후 나머지 값 )
 *
 * 시간복잡도 : N
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String tArray = bufferedReader.readLine();
        int[] tIntArray = Arrays.stream(tArray.split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] split = bufferedReader.readLine().split(" ");
        int T = Integer.parseInt(split[0]);
        int P = Integer.parseInt(split[1]);

        int tBundleCount = 0;
        int pBundleCount = 0;
        int penCount = 0;

        for (int i : tIntArray) {
            tBundleCount += i / T;
            if (i % T != 0) {
                tBundleCount++;
            }
        }

        pBundleCount = N / P;
        penCount = N % P;

        bufferedWriter.write(tBundleCount + "\n" + pBundleCount + " " + penCount);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

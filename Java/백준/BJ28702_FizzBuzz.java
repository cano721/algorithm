import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * 3개 문자를 제공해서 다음 문자를 찾는 문제.
 *
 * 3개 문자 중 1개는 무조건 숫자로 이루어짐.
 *
 * 해당 숫자의 위치를 기반으로 3개의 문자 다음에 나올 숫자를 예측 후
 * 3의 배수, 5의 배수 여부를 바탕으로 정답 출력.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = bufferedReader.readLine();
        String B = bufferedReader.readLine();
        String C = bufferedReader.readLine();

        int answerInt = 0;
        String regex = "[0-9]+";

        if(A.matches(regex)){
            answerInt = Integer.parseInt(A) + 3;
        } else if(B.matches(regex)){
            answerInt = Integer.parseInt(B) + 2;
        } else {
            answerInt = Integer.parseInt(C) + 1;
        }

        boolean is3 = answerInt % 3 == 0;
        boolean is5 = answerInt % 5 == 0;

        String answer = String.valueOf(answerInt);

        if(is3 && is5){
            answer = "FizzBuzz";
        } else if(is3){
            answer = "Fizz";
        } else if(is5){
            answer = "Buzz";
        }

        bufferedWriter.write(answer);

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
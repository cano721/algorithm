import java.io.*;
import java.util.*;

public class BJ4673_셀프넘버 {
    public static void main(String[] args) {
        int [] numbers = new int[10001];

        int num = 1;

        while(num <10000){
            int sum = num;
            int num2 = num;
            while(num2 > 0){
                sum += num2 % 10;
                num2 /= 10;
            }
            if (sum <= 10000){
                numbers[sum] = 1;
            }
            num += 1;
        }
        for(int i = 1; i<=10000; i++){
            if(numbers[i] == 0){
                System.out.println(i);
            }
        }
    }
}

import java.util.*;

public class BJ2475_검증수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = 0;

        for(int i = 0; i< 5; i ++){
            num += (int)Math.pow(sc.nextInt(),2);
        }
        System.out.println(num%10);
    }
}

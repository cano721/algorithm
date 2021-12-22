import java.util.*;

public class BJ2920_음계 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine().replaceAll("\\s+", ""));

        if(num == 12345678){
            System.out.println("ascending");
        }else if(num == 87654321){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}

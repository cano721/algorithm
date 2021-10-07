import java.io.*;
import java.util.*;

public class BJ15596_정수N개의합 {
    public static long main(int[] a){
        
        long sum = 0;
        for(int v: a){
            sum += v;
        }

        return sum;
        
    }
}

import java.io.*;
import java.util.*;

public class BJ3053_택시기하학 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double r = Double.parseDouble(br.readLine());

        System.out.println(r*r*Math.PI);
        System.out.println(r*r*2);

    }
}


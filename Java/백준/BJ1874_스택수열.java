import java.util.*;
import java.io.*;


/**
 * 
 */
public class BJ1874_스택수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for(int i = 1; i <= n; i++){
            while(!stack.isEmpty() && arr[idx] == stack.peek()){
                stack.pop();
                arr[idx] = 0;
                idx++;
                sb.append('-').append('\n');
            }
            stack.add(i);
            sb.append('+').append('\n');
        }
        while(!stack.isEmpty()){
            if(arr[idx] == stack.pop()){
                arr[idx] = 0;
                idx++;
                sb.append('-').append('\n');
            }else{
                break;
            }
        }
        if(idx != n || arr[idx-1] != 0){
            System.out.println("NO");
        }else{
            System.out.println(sb);
        }
    }
}

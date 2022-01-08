/**
 * 구현문제
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class BJ1107_리모컨 {
    public static int[] btn;
    public static String n;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = br.readLine();
        int m = Integer.parseInt(br.readLine());
        btn = new int[10];
        // 고장난 버튼이 있을때 체크
        if(m > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int trouble = Integer.parseInt(st.nextToken());
                btn[trouble] = 1;
            }
        }

        // 찾는 채널이 100번이면 0 출력
        if(n.equals("100")){
            System.out.println(0);
        }else{
            // 위아래 증가로만 만들었을때
            click("100");
            // 숫자버튼을 클릭하여 만들어서 비교했을때
            find("");
            System.out.println(answer);
        }
    }

    public static void find(String check){
        // 한칸 클때 체크(종료문)
        if(check.length() == n.length()+1){
            click(check);
            return;
        }

        // 한칸 작거나 같을때 체크
        if(check.length() == n.length()-1 || check.length() == n.length()){
            click(check);
        }

        for(int i = 0; i < 10; i++){
            // 쓸 수 있는 버튼일때
            if(btn[i] == 0){
                find(check+String.valueOf(i));
            }
        }
        
    }

    public static void click(String check){
        if(check.equals("")) return;
        int channel = Integer.parseInt(n);
        int checkNum = Integer.parseInt(check);

        int clickNum = Math.abs(channel - checkNum);
        answer = Math.min(answer, clickNum + check.length());
    }
}

/**
    1. 주어진 수대로 별 찍기
**/

import java.util.Scanner;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 0; i < b; i++){
            bw.write("*".repeat(a) +"\n");
        }
        bw.flush();
        bw.close();
    }
}
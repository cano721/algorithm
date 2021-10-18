import java.util.*;
import java.io.*;


public class BJ11729_하노이탑이동순서 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        bw.write((int) (Math.pow(2, n) - 1) + "\n");
 
		Hanoi(n, 1, 2, 3);
		bw.flush();
		bw.close();
    }

    public static void Hanoi(int n, int start, int mid, int to) throws IOException {
		// 이동할 원반의 수가 1개라면?
		if (n == 1) {
			bw.write(start + " " + to + "\n");
			return;
		}
		// STEP 1 : N-1개를 A에서 B로 이동
		Hanoi(n - 1, start, to, mid);
		
		// STEP 2 : 1개를 A에서 C로 이동
		bw.write(start + " " + to + "\n");
		
		// STEP 3 : N-1개를 B에서 C로 이동
		Hanoi(n - 1, mid, start, to);
 
	}
}

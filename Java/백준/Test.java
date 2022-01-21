/**
 * 구간합 구하기 펜윅트리 버전 코드
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class Test {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 데이터 변경 개수
        int k = Integer.parseInt(st.nextToken()); // 구간합 구하는 횟수

        // 수 저장 배열
        long[] arr = new long[n+1];
		
		FenwickTree ftree = new FenwickTree(arr.length);
        
		for(int i = 1; i <= n; i++){
            arr[i] = Long.parseLong(br.readLine());
			ftree.update(i, arr[i]);
        }

        
        for(int i = 0; i < m+k; i++){
            st = new StringTokenizer(br.readLine());

            // 명령어
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            // 데이터 변경 명령어
            if(cmd == 1){
                ftree.update(a,b-arr[a]);
                arr[a] = b;
            // 구간합 명령어
            }else{
                bw.write(ftree.sum((int)b) -ftree.sum(a-1) +"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static class FenwickTree{
        long tree[];
        int treeSize;

        public FenwickTree(int arrSize){
            tree = new long[arrSize+1];
        }

        public void update(int idx, long diff){
            while(idx < tree.length){
				tree[idx] += diff;
				idx += (idx & -idx);
			}
        }

        public long sum(int idx){
            long result = 0;
			while(idx > 0){
				result += tree[idx];
				idx -= (idx & -idx);
			}

			return result;
        }
    }
}

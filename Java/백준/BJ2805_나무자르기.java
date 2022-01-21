import java.util.*;
import java.io.*;


/**
 * 이분탐색으로 톱날의 높이를 설정 후에
 * 나무집합 전체 포문 돌아서 확인
 * log20억*백만
 */
public class BJ2805_나무자르기 {

    public static int n,m,h;
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        

        //이분탐색 시작값
        int start = 0;
        int end = 0; //최대 높이값

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            end = Math.max(num,end);
        }

        binary_search(start,end);
        System.out.println(h);
    }

    public static void binary_search(int start,int end){

        while(start <= end){
            int mid = (start+end)/2;
            long tree = 0;
            for(int v: arr){
                if(v > mid){
                    tree += v-mid;
                }
            }

            if(tree < m){
                end = mid-1;
            }else{
                start = mid+1;
                h = mid;
            }
        }
    }
}

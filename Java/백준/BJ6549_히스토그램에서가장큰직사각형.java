/**
 * 1. 분할정복과 세그먼트 트리
 * 
 * 폭은 1로 직사각형이 고정되어있으므로,
 * 
 * 세그먼트트리로 구간 내 최소 높이의 직사각형 찾기
 * 
 * 최소 높이를 찾았을때 구간 폭 을 곱해서 넓이를 구하기
 * 
 * 그다음 최소 높이를 제외한 왼쪽 오른쪽 구간으로 나누어 계산
 * 
 * (고른 최소높이로는 현재 구간이 제일 크기때문)
 * 
 * 세그먼트 트리 반환값은 최소높이를 가진 직사각형의 인덱스값을 반환
 * 
 * (주의점: 인트 * 인트는 인트로 나오므로 하나를 long 강제 형변환)
 * 
 * 
 * 2. 스택 포기!
 * 
 */

import java.util.*;

import javax.swing.text.Segment;

import java.io.*;

// 1번풀이
public class BJ6549_히스토그램에서가장큰직사각형 {
    public static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 직사각형의 수
            
            if(n == 0){
                break;
            }
            int[] arr = new int[n+1];
            
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Segment stree = new Segment(n);
            stree.init(arr, 1, 1, n);
            
            answer = 0;
            // 최대 넓이 찾기
            split(arr,stree,1,n);
            bw.write(answer +"\n");
        }

        bw.flush();
        bw.close();

    }

    public static void split(int[] arr,Segment stree, int start, int end){
        
        // 직사각형 하나일때
        if(start == end){
            int h = arr[start];
            int w = 1;
            answer = Math.max(answer,(long)h*w);
            return;
        }

        // 최소 높이 인덱스 찾기
        int minIdx = stree.min(arr, 1, 1, arr.length-1, start, end);

        // 높이
        int h = arr[minIdx];

        // 폭
        int w = end-start+1;

        //최대넓이 변경
        answer = Math.max(answer,(long)h*w);

        // 왼쪽기준 분할 가능 시
        if(minIdx > start){
            split(arr, stree, start, minIdx-1);
        }
        
        // 오른쪽 분할 가능 시
        if(minIdx < end){
            split(arr, stree, minIdx+1, end);
        }
    }

    // 최솟값 인덱스를 반환하는 세그먼트 트리
    public static class Segment{
        int[] tree;
        int treeSize;

        public Segment(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            treeSize = (int) Math.pow(2, h+1);
            tree = new int[treeSize];
        }

        public int init(int[] arr, int node, int start, int end){
            if(start == end){
                return tree[node] = start;
            }

            int a = init(arr,node*2,start,(start+end)/2);
            int b = init(arr,node*2+1,(start+end)/2+1,end);
            
            if(arr[a] < arr[b]){
                tree[node] = a;
            }else{
                tree[node] = b;
            }

            return tree[node];
        }

        public int min(int[] arr,int node, int start, int end, int left, int right){
            if(start > right || end < left){
                return -1;
            }

            if(start >= left && end <= right){
                return tree[node];
            }

            int a = min(arr, node*2,start,(start+end)/2,left,right);
            int b = min(arr, node*2+1,(start+end)/2+1,end,left,right);

            if(a == -1){
                return b;
            }else if(b == -1){
                return a;
            }else{
                if(arr[a] < arr[b]){
                    return a;
                }else{
                    return b;
                }
            }
        }
    }
}


// 2번 스택 정답 코드
// public class BJ6549_히스토그램에서가장큰직사각형 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st;

//         while(true){
//             st = new StringTokenizer(br.readLine());
//             int n = Integer.parseInt(st.nextToken()); // 직사각형의 수
            
//             if(n == 0){
//                 break;
//             }
//             int[] arr = new int[n];
            
//             for(int i = 0; i < n; i++){
//                 arr[i] = Integer.parseInt(st.nextToken());
//             }

//             long answer = 0;
//             Stack<Integer> stack = new Stack<>();
            
//             for(int i = 0; i < n; i++){
//                 while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
//                     int idx = stack.pop();

//                     int h = arr[idx];

//                     long w = stack.isEmpty() ? i : i-1-stack.peek();
//                     answer = Math.max(answer,h*w);
//                 }
//                 stack.push(i);
//             }

//             while(!stack.isEmpty()){
//                 int idx = stack.pop();

//                 int h = arr[idx];

//                 long w = stack.isEmpty() ? n : n-1-stack.peek();
//                 answer = Math.max(answer,h*w);
//             }
//             bw.write(answer +"\n");
//         }

//         bw.flush();
//         bw.close();

//     }
// }
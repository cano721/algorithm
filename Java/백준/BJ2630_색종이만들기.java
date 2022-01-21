
/**
 * 
 * 1.
 * 시작좌표와 끝나는 좌표를 매개변수로 받아서
 * 받은 맵의 색깔이 같은지 확인(2차원 누적합으로 체크)
 * 
 * 같지 않다면 분할정복으로 나눠서 체크
 * 
 * 2. 훨씬 쉬운 풀이가 있었따...
 * 
 * 그냥 시작좌표와 사이즈만 넣어주고,
 * x,y,n;
 * 들어온 좌표와 사이즈를 통해 그 정사각형이 전부 들어온 좌표와 같은 색인지 확인.
 * 
 * 아니면 분할...
 * 
 * (x,y,n);
 * 
 * 이런형태로 체크 가능
 * for(int a = x; a < x+n; a++){
 *  for(int b = y; b < y+n; b++){
 *      if(map[x][y] != map[a][b]){
 *          check =false;
 *      }
 *  }
 * }
 * 
 */
import java.util.*;
import java.io.*;
public class BJ2630_색종이만들기 {

    public static int[][] map, sumMap;
    public static int blue = 0,white = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        sumMap = new int[n+1][n+1];

        StringTokenizer st;
        // 원본 배열
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 배열
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sumMap[i][j] = map[i][j] + sumMap[i][j-1] + sumMap[i-1][j] - sumMap[i-1][j-1];
            }
        }

        slice(n,1,1,n,n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void slice(int size,int x1, int y1, int x2, int y2){
        if(x1 == 0 || y1 == 0 || x2 == 0 || y2 == 0){
            return;
        }
        // 더이상 자를 수 없을때
        if(size == 1){
            if(map[x2][y2] == 1){
                blue++;
            }else{
                white++;
            }
            return;
        }

        // 현재 색종이가 파란색으로 되어있을때 총 숫자
        int answerNum = (x2-x1+1)*(y2-y1+1);
        // 현재 색종이의 총 숫자
        int checkNum = sumMap[x2][y2] - sumMap[x1-1][y2] - sumMap[x2][y1-1] + sumMap[x1-1][y1-1];
        // 다 파란색이면 더하기
        if(checkNum == answerNum){
            blue++;
        // 다 하얀색이면 더하기
        }else if(checkNum == 0){
            white++;
        // 아니면 나누기
        }else{
            // 4조각
            slice(size/2, x1, y1,(x1+x2)/2,(y1+y2)/2);
            slice(size/2, x1,(y1+y2)/2+1,(x1+x2)/2,y2);
            slice(size/2,(x1+x2)/2+1,y1,x2,(y1+y2)/2);
            slice(size/2,(x1+x2)/2+1,(y1+y2)/2+1,x2,y2);
        }
    }
}

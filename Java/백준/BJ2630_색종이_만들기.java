import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * N*N 맵 생성
 *
 * 0,0부터 N,N만큼의 맵이 동일한 색상인지 체크
 * 만약 다른 색상이 나올경우, N/2씩 잘라서 재체크 (N/2, N/2)
 *
 * 다 같으면 해당 컬러의 개수 증가
 *
 * dfs으로 풀이
 *
 * 시간복잡도 : N*N*7 (맵을 돌건데, 최대 K의 크기인 7번 돌 수 있음)
 */
public class Main {

    public static int[][] map;
    public static int white;
    public static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];

        for(int i=0; i < N; i++){
            String[] strs = bufferedReader.readLine().split(" ");
            for(int j = 0; j < strs.length; j++){
                int color = Integer.parseInt(strs[j]);
                map[i][j] = color;
            }
        }

        dfs(0,0,N);

        bufferedWriter.write(white + "\n");
        bufferedWriter.write(String.valueOf(blue));

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void dfs(int x, int y, int length){

        int currentColor = map[x][y];

        for(int i = x; i < x+length; i++){
            for(int j = y; j < y+length; j++){
                if(i == x && j == y){
                    continue;
                }
                if(currentColor != map[i][j]){
                    dfs(x,y,length/2);
                    dfs(x+length/2,y,length/2);
                    dfs(x,y+length/2,length/2);
                    dfs(x+length/2,y+length/2,length/2);
                    return;
                }
            }
        }

        if(currentColor == 0){
            white++;
        } else {
            blue++;
        }
    }

}
/**
 * 구현문제
 * 
 */

import java.util.*;
import java.io.*;

public class BJ9019_DSLR {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st;

    int t= Integer.parseInt(br.readLine());

    for(int tc = 0; tc < t; tc++){
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(check(a,b) +"\n");
    }
    bw.flush();
    bw.close();
   }

   public static String check(int a, int b){
       Queue<Group> q = new LinkedList<>();
       boolean[] visited = new boolean[10000];
       visited[a] = true;
       q.offer(new Group(a,b,""));

       while(!q.isEmpty()){
           Group cur = q.poll();

           if(cur.num == cur.target){
               return cur.command;
           }

           int ni = d(cur.num);
           if(visited[ni] == false){
               q.offer(new Group(ni,cur.target,cur.command+"D"));
               visited[ni] = true;
           }
           ni = s(cur.num);
           if(visited[ni] == false){
               q.offer(new Group(ni,cur.target,cur.command+"S"));
               visited[ni] = true;
           }
           ni = l(cur.num);
           if(visited[ni] == false){
               q.offer(new Group(ni,cur.target,cur.command+"L"));
               visited[ni] = true;
           }
           ni = r(cur.num);
           if(visited[ni] == false){
               q.offer(new Group(ni,cur.target,cur.command+"R"));
               visited[ni] = true;
           }
        }
        return "";
   }

   public static int d(int i){
        return (i*2) % 10000;
   }

   public static int s(int i){
       if(i == 0){
           return 9999;
       }else{
           return i-1;
       }
   }

   public static int l(int i){
       String si = String.valueOf(i);

       si = si.substring(1) + si.substring(0, 1);

       return Integer.valueOf(si);
   }

   public static int r(int i){
       String si = String.valueOf(i);

       si = si.substring(si.length()-1,si.length()) + si.substring(0,si.length()-1);

       return Integer.valueOf(si);
   }

   public static class Group{
       int num;
       int target;
       String command;

       public Group(int i,int j, String str){
           this.num = i;
           this.target = j;
           this.command = str;
       }
   }
}

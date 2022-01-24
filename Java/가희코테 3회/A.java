/**
 * 구현 문제
 * 
 * 각 역 거리정보 해시맵에 저장
 * 
 * 각 역 도착시간,출발시간 해시맵 저장
 * 
 * 주의점
 * 1. 이번역 도착시간보다 이번역 출발시간이 적을 시 다음날출발한것이므로,
 * 출발시간 +3600
 * 
 * 2. 전역 출발시간보다 다음역 도착시간이 적을시,
 * 다음날 도착한것이므로 도착시간 +3600
 * 
 * 3. 역방향도 존재하므로 절대값(출발거리- 도착거리)
 * 
 * 4. 거리 / (도착역 도착시간 - 출발역 출발시간)/60
 * 
 */

import java.util.*;
import java.io.*;

public class A {

    public static Map<String,Double> dMap = new HashMap<>();
    public static Map<String,int[]> time = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        inputData();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int pstime = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String station = st.nextToken();
            String end = st.nextToken();
            String start = st.nextToken();

            int eTime = change(end);
            int sTime = change(start);

            if(pstime > eTime){
                eTime += 3600;
            }
            if(sTime < eTime){
                sTime += 3600;
            }
            time.put(station, new int[] {sTime,eTime});
            time.put(station,new int[] {sTime,eTime});
            pstime = sTime;
        }

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            String start_station = st.nextToken();
            String end_station = st.nextToken();

            double start_distance = dMap.get(start_station);
            double end_distance = dMap.get(end_station);

            double distance = Math.abs(end_distance-start_distance);

            //도착역 도착시간
            int end_time = time.get(end_station)[1];
            // 출발역 출발시간
            int start_time = time.get(start_station)[0];

            // 시간 단위
            double time = (end_time-start_time);

            bw.write(String.format("%.8f",(distance/time)*60) +"\n");
        }
        
        bw.flush();
        bw.close();
    }

    public static int change(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        int time = 0;
        if(str1.equals("-")){
            return 0;
        }else{
            time += Integer.valueOf(str1)*60;
            time += Integer.valueOf(str2);
        }
        return time;
    }


    public static void inputData(){
        dMap.put("Seoul",0d);
        dMap.put("Yeongdeungpo",9.1);
        dMap.put("Anyang",23.9);
        dMap.put("Suwon",41.5);
        dMap.put("Osan",56.5);
        dMap.put("Seojeongri",66.5);
        dMap.put("Pyeongtaek",75.0);
        dMap.put("Seonghwan",84.4);
        dMap.put("Cheonan",96.6);
        dMap.put("Sojeongni",107.4);
        dMap.put("Jeonui",114.9);
        dMap.put("Jochiwon",129.3);
        dMap.put("Bugang",139.8);
        dMap.put("Sintanjin",151.9);
        dMap.put("Daejeon",166.3);
        dMap.put("Okcheon",182.5);
        dMap.put("Iwon",190.8);
        dMap.put("Jitan",196.4);
        dMap.put("Simcheon",200.8);
        dMap.put("Gakgye",204.6);
        dMap.put("Yeongdong",211.6);
        dMap.put("Hwanggan",226.2);
        dMap.put("Chupungnyeong",234.7);
        dMap.put("Gimcheon",253.8);
        dMap.put("Gumi",276.7);
        dMap.put("Sagok",281.3);
        dMap.put("Yangmok",289.5);
        dMap.put("Waegwan",296.0);
        dMap.put("Sindong",305.9);
        dMap.put("Daegu",323.1);
        dMap.put("Dongdaegu",326.3);
        dMap.put("Gyeongsan",338.6);
        dMap.put("Namseonghyeon",353.1);
        dMap.put("Cheongdo",361.8);
        dMap.put("Sangdong",372.2);
        dMap.put("Miryang",381.6);
        dMap.put("Samnangjin",394.1);
        dMap.put("Wondong",403.2);
        dMap.put("Mulgeum",412.4);
        dMap.put("Hwamyeong",421.8);
        dMap.put("Gupo",425.2);
        dMap.put("Sasang",430.3);
        dMap.put("Busan",441.7);
    }}

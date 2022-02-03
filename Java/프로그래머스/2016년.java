/**
    1. 해당날짜를 일 단위로 변환
    
    2. 변환한 날짜를 일주일단위로 나머지 구하기
    
    3. 나머지 구한 뒤에 반환
**/

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int day = parsing(a,b);
        day %= 7;
        answer = parsingStr(day);
        
        return answer;
    }
    
    public int parsing(int a, int b){
        
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int day = 0;
        
        for(int i = 1; i < a; i++){
            day += month[i];
        }
        day += b;
        return day;
    }
    
    public String parsingStr(int day){
        
        switch(day){
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
            default:
                return "THU";
        }
    }
}
/**
    1. replaceAll로 0 제거.
    
    2. 길이비교하여 0 제거 개수 체크
    
    3. 남은 길이를 2진법으로 다시 변환
    
    4. 반복하여 1이 남을때까지 체크하여 정답 반환.
**/

class Solution {
    public int[] solution(String s) {
        
        int zeroCnt = 0;
        int convertCnt = 0;
        
        while(!s.equals("1")){
            int length = s.length();
            s = s.replaceAll("0","");
            int newLength = s.length();
            zeroCnt += length - newLength;
            s = Integer.toBinaryString(newLength);
            convertCnt++;
        }
        
        
        return new int[] {convertCnt, zeroCnt};
    }
}
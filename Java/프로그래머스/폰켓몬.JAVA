/**
    1. 폰켓몬의 종류번호 배열을 생성
    
    2. 주어진 폰켓몬을 종류별로 개수 파악
    
    3. 주어진 폰켓몬/2 만큼 종류 선택
    
    4. 출력
**/
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int cnt = nums.length /2;
        
        int[] arr = new int[200_001];
        
        for(int v: nums){
            arr[v]++;
        }
        
        for(int v : arr){
            if(v != 0){
                cnt--;
                answer++;
            }
            if(cnt == 0){
                break;
            }
        }
        return answer;
    }
}
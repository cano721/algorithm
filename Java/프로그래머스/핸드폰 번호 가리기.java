/**
    1. 구현
**/

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();
        String sub = phone_number.substring(len-4,len);
        String temp = "*".repeat(len-4);
        answer = temp+sub;
        return answer;
    }
}
/**
    실패
    블로그참조
    https://leedakyeong.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A9%80%EC%A9%A1%ED%95%9C-%EC%82%AC%EA%B0%81%ED%98%95-in-python

    유클리드 호제법으로 최대 공약수 구하기

    1. 최대공약수를 구한 뒤, 그에 따른 수식 처리

**/

class Solution {
    public long solution(int w, int h) {
        
        long all = (long)w*h;
        
        int g = gcd(w,h);
        
        return all -(w+h-g);
    }
    
    public int gcd(int w, int h){
        
        if(h == 0) return w;
        
        return gcd(h,w%h);
    }
}
public class Test {
    public static void main(String[] args) {
        
        int full = (1<<5)-1;
        System.out.println("꽉찬 집합: " + Integer.toBinaryString(full));
        int mfull = -1;
        System.out.println("인트(32비트) 꽉 찬 집합: " + Integer.toBinaryString(mfull));
        
        int a = 32;
        a |= (1<<3);
        System.out.println("4번째 원소 추가: " + Integer.toBinaryString(a));
    
        System.out.println("4번째 원소 반환: " + Integer.toBinaryString(a & (1<<3)));

        a &= ~(1<<3);
        System.out.println("4번째 원소 삭제: " + Integer.toBinaryString(a));

        a ^= (1<<3);
        System.out.println("4번째 원소 토글: " + Integer.toBinaryString(a));

        if((a &(1<<3)) == (1<<3)){
            System.out.println("4번째 원소 포함여부 확인 완료");
        }

        int x = 38;
        int y = 33;

        System.out.println("x: " + Integer.toBinaryString(x));
        System.out.println("y: " + Integer.toBinaryString(y));
        
        System.out.println("합집합: " + Integer.toBinaryString(x|y));
        System.out.println("교집합: " + Integer.toBinaryString(x&y));
        System.out.println("차집합: " + Integer.toBinaryString(x&-y));
        System.out.println("둘중에 하나만 포함집합: " + Integer.toBinaryString(x^y));

        System.out.println("x집합 켜진 원소 수: " + Integer.bitCount(x));

        x &= ((1<<3) -1);
        System.out.println("3번째 원소 왼쪽 0: " + Integer.toBinaryString(x));
        x = 38;
        x &= (-1 <<3);
        System.out.println("3번째 원소 오른쪽 0: " + Integer.toBinaryString(x));

        a = 14; // {4,3,2}
        System.out.println("a: " + Integer.toBinaryString(a));
        for (int subA= a ; subA>0; subA = ((subA - 1) & a)){
            System.out.println("a 부분집합: " +Integer.toBinaryString(subA));
         }
    }
}
